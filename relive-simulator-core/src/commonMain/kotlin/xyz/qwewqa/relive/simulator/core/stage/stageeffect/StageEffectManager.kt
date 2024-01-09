package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.common.DisplayStageEffectData
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.stage.BasicTargetSelectionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.ContinuousBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.platformMapOf
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets.allyPlayer
import xyz.qwewqa.relive.simulator.core.stage.team.Team

class StageEffectManager(val team: Team) {
  private val levels = platformMapOf<StageEffect, Int>()
  private var activeStacks = mutableListOf<StageEffectStack>()
  private val activeEffects = platformMapOf<StageEffect, ActiveStageEffect>()
  private val teamEffects = platformMapOf<ContinuousBuffEffect<Unit>, MutableList<Int>>()

  // TODO: stop using this and just check whether targets changed each refresh
  private var targetsValid = true

  fun values() = levels.mapNotNull { (k, v) -> (k to v).takeIf { v > 9 } }

  fun add(effect: StageEffect, turns: Int, level: Int = 1) {
    if (turns <= 0) return
    if (effect.category == BuffCategory.Positive &&
        level <= (teamEffects[Buffs.PositiveStageEffectResistanceUp]?.maxOrNull() ?: 0)) {
      return
    }
    if (effect.category == BuffCategory.Negative &&
        level <= (teamEffects[Buffs.NegativeStageEffectResistanceUp]?.maxOrNull() ?: 0)) {
      return
    }
    val adjustedLevel =
        level -
            when (effect.category) {
              BuffCategory.Positive ->
                  teamEffects[Buffs.RestrictPositiveStageEffectBuff]?.maxOrNull() ?: 0
              BuffCategory.Negative ->
                  teamEffects[Buffs.OpposeNegativeStageEffectBuff]?.maxOrNull() ?: 0
            }
    if (adjustedLevel <= 0) {
      return
    }
    activeStacks += StageEffectStack(effect, turns, level)
    refreshLevels()
  }

  fun refreshLevels() {
    levels.keys.forEach { levels[it] = 0 }
    for (stack in activeStacks) {
      levels[stack.effect] = (levels[stack.effect] ?: 0) + stack.level
    }
  }

  fun adjustLevels(category: BuffCategory, count: Int, delta: Int) {
    activeStacks
        .asReversed()
        .asSequence()
        .filter { it.effect.category == category }
        .take(count)
        .forEach { it.adjustLevel(delta) }
    activeStacks.removeAll { it.level == 0 }
    refreshLevels()
  }

  private fun StageEffectStack.adjustLevel(delta: Int) {
    level = (level + delta).coerceIn(0, 5)
  }

  fun tick() {
    activeStacks.forEach { stack -> stack.turns-- }
    activeStacks.removeAll { it.turns <= 0 }
    refreshLevels()
  }

  fun invalidateTargets() {
    targetsValid = false
  }

  fun refresh() {
    if (!targetsValid) {
      activeEffects.forEach { (_, effect) -> effect.deactivate() }
      activeEffects.clear()
      targetsValid = true
    }
    levels.forEach { (effect, level) ->
      if (level > 0) {
        val previousStatus = activeEffects[effect]
        if (previousStatus == null) {
          activeEffects[effect] = ActiveStageEffect(effect, effect.activate(level), level)
        } else {
          activeEffects[effect] = previousStatus.update(level)
        }
      } else {
        activeEffects.remove(effect)?.deactivate()
      }
    }
  }

  fun getDisplayData(): List<DisplayStageEffectData> {
    val maxTurns = platformMapOf<StageEffect, Int>()
    activeStacks.forEach { stack ->
      maxTurns[stack.effect] = maxOf(maxTurns[stack.effect] ?: 0, stack.turns)
    }
    return maxTurns.mapNotNull { (effect, turns) ->
      DisplayStageEffectData(
          effect.iconId,
          levels[effect]!!.coerceAtMost(5),
          turns,
      )
    }
  }

  private fun StageEffect.activate(level: Int): StageEffectActiveBuffValues =
      buffs.map { buff ->
        val value = buff.values[level.coerceAtMost(buff.values.size) - 1]
        // Note that the team is passed in for both the own and enemy teams, because enemy targeting
        // stage effects
        // are added to the enemy team but retain the enemy targeting.
        if (buff.target == allyPlayer) {
          teamEffects.getOrPut(buff.effect) { mutableListOf() } += value
          listOf(
              null to value,
          )
        } else {
          val targets = buff.target.getTargets(BasicTargetSelectionContext(null, team, team), null)
          targets.map { actor ->
            actor.buffs.activatePsuedoBuff(buff.effect, value.toI54())
            actor to value
          }
        }
      }

  // TODO: Support changing targets
  private fun StageEffect.update(
      values: StageEffectActiveBuffValues,
      level: Int
  ): StageEffectActiveBuffValues {
    return values.zip(buffs).map { (buffValues, buff) ->
      val newValue = buff.values[level.coerceAtMost(buff.values.size) - 1]
      buffValues.map { (actor, oldValue) ->
        if (actor == null) {
          val values = teamEffects[buff.effect]!!
          values[values.indexOf(oldValue)] = newValue
        } else {
          actor.buffs.updatePseudoBuff(buff.effect, oldValue.toI54(), newValue.toI54())
        }
        actor to newValue
      }
    }
  }

  private fun StageEffect.deactivate(values: StageEffectActiveBuffValues) =
      values.zip(buffs).forEach { (buffValues, buff) ->
        buffValues.forEach { (actor, value) ->
          if (actor == null) {
            teamEffects[buff.effect]!!.remove(value)
          } else {
            actor.buffs.removePseudoBuff(buff.effect, value.toI54())
          }
        }
      }

  fun ActiveStageEffect.update(level: Int): ActiveStageEffect =
      if (level == this.level) {
        this
      } else {
        ActiveStageEffect(effect, effect.update(values, level), level)
      }

  fun ActiveStageEffect.deactivate() = effect.deactivate(values)
}

class StageEffectStack(val effect: StageEffect, var turns: Int, var level: Int)

typealias StageEffectActiveBuffValues = List<List<Pair<Actor?, Int>>>

data class ActiveStageEffect(
    val effect: StageEffect,
    val values: StageEffectActiveBuffValues,
    val level: Int
)
