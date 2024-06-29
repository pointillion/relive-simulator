package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.coerceAtLeast
import xyz.qwewqa.relive.simulator.core.i54.coerceIn
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.i54.minus
import xyz.qwewqa.relive.simulator.core.i54.plus
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.getEffectiveCoef
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BlindnessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.FreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.FrostbiteBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterBlindnessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterFreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterFrostbiteBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterInvincibilityBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterPerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.InvincibilityBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedNormalBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedSpecialBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NormalBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NormalSuperReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SpecialBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SpecialSuperReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.accuracy
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.modifier.climaxDamageAdjustment
import xyz.qwewqa.relive.simulator.core.stage.modifier.critical
import xyz.qwewqa.relive.simulator.core.stage.modifier.damageDealtUpModifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.damageReceivedModifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.dexterity
import xyz.qwewqa.relive.simulator.core.stage.modifier.evasion
import xyz.qwewqa.relive.simulator.core.stage.modifier.normalDefense
import xyz.qwewqa.relive.simulator.core.stage.modifier.specialDefense

interface DamageCalculator {
  fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute)
}

open class RandomDamageCalculator : DamageCalculator {
  override fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute): Unit =
      attacker.context.run {
        if (!attacker.isAlive) return@run
        log("Hit", category = LogCategory.DAMAGE, debug = true) {
          "[${attacker.name}] attempts to hit [${target.name}]."
        }
        actionLog.attemptedHit = true
        actionLog.markConsumeOnAttackCountableBuffs(self)

        val result = calculateDamage(attacker, target, hitAttribute)
        result.apply {
          log(
              "DamageCalculator",
              summary = { "[${attacker.name}] attacks [${target.name}]." },
              category = LogCategory.DAMAGE) {
                "Base: $base, Critical: $critical, Critical Chance: $criticalChance, Hit Chance: $hitChance.\n" +
                    "Possible base rolls: ${possibleRolls(false)}.\n" +
                    "Possible critical rolls: ${possibleRolls(true)}."
              }
        }
        if (target.buffs.tryRemove(Buffs.EvasionBuff) ||
            target.buffs.tryRemove(Buffs.GreaterEvasionBuff)) {
          if (PerfectAimBuff !in self.buffs &&
              GreaterPerfectAimBuff !in self.buffs &&
              !hitAttribute.focus) {
            log("Hit", category = LogCategory.DAMAGE) {
              "Miss against [${target.name}] from Evade."
            }
            return@run
          }
        }
        if (PerfectAimBuff in self.buffs ||
            GreaterPerfectAimBuff in self.buffs ||
            hitAttribute.focus ||
            stage.random.nextDouble() < result.hitChance) {
          val n = if (result.variance) stage.random.nextInt(-8, 9) else 0
          val isCritical = stage.random.nextDouble() < result.criticalChance
          val damage =
              if (isCritical) {
                    result.critical.toDouble() * (100 + n) / 100
                  } else {
                    result.base.toDouble() * (100 + n) / 100
                  }
                  .toI54()
          val superReflect =
              when (hitAttribute.damageType) {
                DamageType.Normal -> NormalSuperReflectBuff in target.buffs
                DamageType.Special -> SpecialSuperReflectBuff in target.buffs
                DamageType.Neutral -> false
              }
          val reflect =
              if (superReflect) 100.i54
              else
                  when (hitAttribute.damageType) {
                    DamageType.Normal -> target.mod { +Modifier.NormalReflect }
                    DamageType.Special -> target.mod { +Modifier.SpecialReflect }
                    DamageType.Neutral -> 0.i54
                  }.coerceIn(0, 100)
          val superReflectModifier = if (superReflect) 2 else 1
          attacker.context.log("Hit", category = LogCategory.DAMAGE) {
            "Landed hit against [${target.name}]."
          }
          attacker.context.log("Hit", category = LogCategory.DAMAGE) {
            "Damage roll: $damage (critical: $isCritical, varianceRoll: $n)."
          }
          val reflected =
              if (hitAttribute.focus || hitAttribute.noReflect) {
                0.i54
              } else {
                damage * reflect * superReflectModifier / 100
              }
          val unreflected = (damage - reflected).coerceAtLeast(0)
          if (reflected > 0)
              attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                "Unreflected: $unreflected, Reflected: $reflected, Super Reflect: ${superReflect}."
              }
          var afterBarrier = unreflected
          if (!hitAttribute.focus) {
            when (hitAttribute.damageType) {
              DamageType.Normal -> listOf(NormalBarrierBuff, LockedNormalBarrierBuff)
              DamageType.Special -> listOf(SpecialBarrierBuff, LockedSpecialBarrierBuff)
              else -> null
            }?.let { barrierEffectType ->
              val barriers = barrierEffectType.flatMap { target.buffs.get(it) }
              if (barriers.isNotEmpty()) {
                for (barrier in barriers.toList()) {
                  if (barrier.value > afterBarrier) {
                    attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                      "Blocked by barrier (damage: $afterBarrier barrierStart: ${barrier.value}, barrierAfter: ${barrier.value - afterBarrier})."
                    }
                    barrier.updateValue(barrier.value - afterBarrier)
                    afterBarrier = 0.i54
                    break
                  } else {
                    attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                      "Destroys barrier (damage: $afterBarrier, after: ${afterBarrier - barrier.value}, barrier: ${barrier.value})."
                    }
                    afterBarrier -= barrier.value
                    barrier.remove()
                  }
                }
              }
            }
          }
          target.damage(afterBarrier, additionalEffects = hitAttribute.addBrilliance)
          if (attacker.context.team != target.context.team) {
            actionLog.damageDealtToEnemy += afterBarrier
          }
          if (reflected > 0) {
            self.damage(reflected, additionalEffects = false)
          }
          if (self.mod { +Modifier.Absorb } > 0) {
            self.heal(afterBarrier * self.mod { +Modifier.Absorb } / 100)
          }
          actionLog.successfulHits++
        } else {
          attacker.context.log("Hit", category = LogCategory.DAMAGE) {
            "Miss against [${target.name}]."
          }
        }
      }

  fun calculateDamage(attacker: Actor, target: Actor, hitAttribute: HitAttribute): DamageResult {
    val acc =
        (100 + attacker.mod { +accuracy } - target.mod { +evasion }).coerceIn(0, 100) *
            (if (BlindnessBuff in attacker.buffs || GreaterBlindnessBuff in attacker.buffs) 0.3
            else 1.0)

    if ((InvincibilityBuff in target.buffs || GreaterInvincibilityBuff in target.buffs) &&
        !hitAttribute.focus) {
      // Critical chance isn't actually 0 against invincible targets, but
      // it doesn't matter, so we'll skip calculating it.
      return DamageResult(0.i54, 0.i54, 0.0, acc / 100.0, false)
    } else if (hitAttribute.mode == HitMode.FIXED) {
      return DamageResult(
          base = hitAttribute.modifier.toI54() / hitAttribute.hitCount,
          critical = hitAttribute.modifier.toI54() / hitAttribute.hitCount,
          criticalChance = 0.0,
          hitChance = acc / 100.0,
          variance = false,
      )
    }

    val base: I54

    if (hitAttribute.mode == HitMode.ELEMENTAL_FIXED) {
      base = hitAttribute.modifier.toI54() / hitAttribute.hitCount
    } else {
      var atk = attacker.mod { actPower }
      if (attacker.inCX) atk = atk * 110 / 100
      val cheerCoef =
          100 +
              (attacker.buffs.getNext(Buffs.CheerBuff) ?: 0.i54) +
              (attacker.buffs.getNext(Buffs.GreaterCheerBuff) ?: 0.i54)
      val modifier =
          (hitAttribute.modifier.toI54() +
              if (attacker.inCX) attacker.mod { +Modifier.ClimaxDamageFixedUp } else 0.i54) ptmul
              cheerCoef
      atk = atk * 2 * modifier / 100

      val def =
          when (attacker.dress.damageType) {
            DamageType.Normal -> target.mod { +normalDefense }
            DamageType.Special -> target.mod { +specialDefense }
            else -> 0.i54
          }.coerceAtLeast(0)

      base = (atk - def).coerceAtLeast(atk / 10) / hitAttribute.hitCount
    }

    val ampCoef =
        if (hitAttribute.ampCondition != null && hitAttribute.ampCondition.evaluate(target)) {
          hitAttribute.ampModifier.toI54()
        } else {
          100.i54
        }

    val attribute = hitAttribute.attribute
    val eleCoef = getEffectiveCoef(attribute, target.dress.attribute)
    val effEleCoef =
        if (eleCoef > 100) {
          100 + attacker.mod { +Modifier.EffectiveDamageUp }
        } else {
          100.i54
        }

    val critCoef =
        100 +
            (attacker.mod { +critical } - target.mod { +Modifier.CriticalDamageReceivedDown })
                .coerceAtLeast(0)
    val dex = attacker.mod { +dexterity }

    val dmgDealtUpCoef = 100 + attacker.mod { +damageDealtUpModifier(target) }
    val dmgDealtDownCoef = 100 - attacker.mod { +Modifier.DamageDealtDown }

    // tentative
    var dmgTakenCoef = 100 + target.mod { +damageReceivedModifier(attacker) }
    if (Buffs.WeakSpotBuff in target.buffs || Buffs.GreaterWeakSpotBuff in target.buffs)
        dmgTakenCoef += 60.i54

    val attributeDamageDealtUpCoef = 100 + (attacker.attributeDamageDealtUp[attribute] ?: 0.i54)
    val againstAttributeDamageDealtUpCoef =
        100 + (attacker.againstAttributeDamageDealtUp[target.dress.attribute] ?: 0.i54)
    val targetAgainstAttributeDamageReceivedDownCoef =
        (100 - (target.againstAttributeDamageReceivedDown[attribute] ?: 0.i54)).coerceAtLeast(50)

    val freezeCoef =
        target.mod {
          100 +
              (30 given { FreezeBuff in target.buffs || GreaterFreezeBuff in target.buffs }) +
              (30 given { FrostbiteBuff in target.buffs || GreaterFrostbiteBuff in target.buffs })
        }

    // cx damage up
    val cxDmgCoef =
        if (attacker.inCXAct) {
          100 + attacker.mod { climaxDamageAdjustment }
        } else {
          100.i54
        }

    val eventBonusCoef = 100 + attacker.eventBonus
    val eventMultiplier = attacker.eventMultiplier

    attacker.context.log(
        "DamageCalculator", category = LogCategory.DAMAGE, summary = { "Damage factors" }) {
          listOf(
                  "base" to base,
                  "eleCoef" to eleCoef,
                  "effEleCoef" to effEleCoef,
                  "critCoef" to critCoef,
                  "attributeDamageDealtUpCoef" to attributeDamageDealtUpCoef,
                  "againstAttributeDamageDealtUpCoef" to againstAttributeDamageDealtUpCoef,
                  "ampCoef" to ampCoef,
                  "eventBonusCoef" to eventBonusCoef,
                  "targetAgainstAttributeDamageReceivedDownCoef" to
                      targetAgainstAttributeDamageReceivedDownCoef,
                  "freezeCoef" to freezeCoef,
                  "cxDmgCoef" to cxDmgCoef,
                  "dmgDealtDownCoef" to dmgDealtDownCoef,
                  "dmgTakenCoef" to dmgTakenCoef,
                  "dmgDealtUpCoef" to dmgDealtUpCoef,
                  "eventMultiplier" to eventMultiplier,
              )
              .joinToString("\n") { (name, value) -> "$name: $value" }
        }

    var dmg = base
    dmg = dmg ptmul eleCoef
    dmg = dmg ptmul effEleCoef
    dmg = dmg ptmul attributeDamageDealtUpCoef
    dmg = dmg ptmul againstAttributeDamageDealtUpCoef
    dmg = dmg ptmul ampCoef // tentative
    dmg = dmg ptmul eventBonusCoef
    dmg = dmg ptmul targetAgainstAttributeDamageReceivedDownCoef // tentative
    dmg = dmg ptmul freezeCoef
    dmg = dmg ptmul cxDmgCoef
    dmg = dmg ptmul dmgDealtDownCoef
    dmg = dmg ptmul dmgTakenCoef
    dmg = dmg ptmul dmgDealtUpCoef
    dmg = dmg ptmul eventMultiplier // tentative
    dmg = dmg ptmul 10

    var criticalDmg = base
    criticalDmg = criticalDmg ptmul eleCoef
    criticalDmg = criticalDmg ptmul effEleCoef
    criticalDmg = criticalDmg ptmul critCoef
    criticalDmg = criticalDmg ptmul attributeDamageDealtUpCoef
    criticalDmg = criticalDmg ptmul againstAttributeDamageDealtUpCoef
    criticalDmg = criticalDmg ptmul ampCoef // tentative
    criticalDmg = criticalDmg ptmul eventBonusCoef
    criticalDmg = criticalDmg ptmul targetAgainstAttributeDamageReceivedDownCoef // tentative
    criticalDmg = criticalDmg ptmul freezeCoef
    criticalDmg = criticalDmg ptmul cxDmgCoef
    criticalDmg = criticalDmg ptmul dmgDealtDownCoef
    criticalDmg = criticalDmg ptmul dmgTakenCoef
    criticalDmg = criticalDmg ptmul dmgDealtUpCoef
    criticalDmg = criticalDmg ptmul eventMultiplier

    return DamageResult(
        base = dmg,
        critical = criticalDmg,
        criticalChance = dex / 100.0,
        hitChance = acc / 100.0,
        variance = true,
    )
  }
}

class MeanDamageCalculator : RandomDamageCalculator() {
  override fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute): Unit =
      attacker.context.run {
        if (!attacker.isAlive) return@run
        log("Hit", category = LogCategory.DAMAGE, debug = true) {
          "[${attacker.name}] attempts to hit [${target.name}]."
        }
        actionLog.attemptedHit = true
        actionLog.markConsumeOnAttackCountableBuffs(self)

        val result = calculateDamage(attacker, target, hitAttribute)
        result.apply {
          log(
              "DamageCalculator",
              summary = { "[${attacker.name}] attacks [${target.name}]." },
              category = LogCategory.DAMAGE) {
                "Base: $base, Critical: $critical, Critical Chance: $criticalChance, Hit Chance: $hitChance.\n" +
                    "Possible base rolls: ${possibleRolls(false)}.\n" +
                    "Possible critical rolls: ${possibleRolls(true)}."
              }
        }
        if (target.buffs.tryRemove(Buffs.EvasionBuff) ||
            target.buffs.tryRemove(Buffs.GreaterEvasionBuff)) {
          if (!(PerfectAimBuff in self.buffs) && !hitAttribute.focus) {
            log("Hit", category = LogCategory.DAMAGE) {
              "Miss against [${target.name}] from Evade."
            }
            return@run
          }
        }
        val hitChance =
            if (PerfectAimBuff in self.buffs || hitAttribute.focus) {
              1.0
            } else {
              stage.random.nextDouble() // To keep rng consistent
              result.hitChance
            }
        if (result.variance) {
          stage.random.nextInt(-8, 9) // To keep rng consistent
        }
        stage.random.nextDouble() // To keep rng consistent (critical roll)
        val hitDamage =
            result.critical * result.criticalChance + result.base * (1 - result.criticalChance)
        val damage = (hitChance * hitDamage).toI54()
        val reflect =
            when (hitAttribute.damageType) {
              DamageType.Normal -> target.mod { +Modifier.NormalReflect }
              DamageType.Special -> target.mod { +Modifier.SpecialReflect }
              DamageType.Neutral -> 0.i54
            }
        attacker.context.log("Hit", category = LogCategory.DAMAGE) {
          "Landed hit against [${target.name}]."
        }
        attacker.context.log("Hit", category = LogCategory.DAMAGE) { "Damage roll: Mean." }
        val reflected =
            if (hitAttribute.focus || hitAttribute.noReflect) 0.i54 else damage * reflect / 100
        val unreflected = damage - reflected
        if (reflected > 0)
            attacker.context.log("Hit", category = LogCategory.DAMAGE) {
              "Unreflected: $unreflected, Reflected: $reflected."
            }
        var afterBarrier = unreflected
        if (!hitAttribute.focus) {
          when (hitAttribute.damageType) {
            DamageType.Normal -> NormalBarrierBuff
            DamageType.Special -> SpecialBarrierBuff
            else -> null
          }?.let { barrierEffectType ->
            val barriers = target.buffs.get(barrierEffectType)
            if (barriers.isNotEmpty()) {
              for (barrier in barriers.toList()) {
                if (barrier.value > afterBarrier) {
                  attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                    "Blocked by barrier (damage: $afterBarrier barrierStart: ${barrier.value}, barrierAfter: ${barrier.value - afterBarrier})."
                  }
                  barrier.updateValue(barrier.value - afterBarrier)
                  afterBarrier = 0.i54
                  break
                } else {
                  attacker.context.log("Hit", category = LogCategory.DAMAGE) {
                    "Destroys barrier (damage: $afterBarrier, after: ${afterBarrier - barrier.value}, barrier: ${barrier.value})."
                  }
                  afterBarrier -= barrier.value
                  barrier.remove()
                }
              }
            }
          }
        }
        target.damage(afterBarrier, additionalEffects = hitAttribute.addBrilliance)
        if (attacker.context.team != target.context.team) {
          actionLog.damageDealtToEnemy += afterBarrier
        }
        if (reflected > 0) {
          self.damage(reflected, additionalEffects = false)
        }
        if (self.mod { +Modifier.Absorb } > 0) {
          self.heal(afterBarrier * self.mod { +Modifier.Absorb } / 100)
        }
        actionLog.successfulHits++
      }
}

class SwitchableDamageCalculator : DamageCalculator {
  private val meanDamageCalculator = MeanDamageCalculator()
  private val randomDamageCalculator = RandomDamageCalculator()

  var isRandom = true

  override fun damage(attacker: Actor, target: Actor, hitAttribute: HitAttribute) {
    if (isRandom) {
      randomDamageCalculator.damage(attacker, target, hitAttribute)
    } else {
      meanDamageCalculator.damage(attacker, target, hitAttribute)
    }
  }
}

data class DamageResult(
    val base: I54,
    val critical: I54,
    val criticalChance: Double,
    val hitChance: Double,
    val variance: Boolean,
) {
  fun possibleRolls(critical: Boolean = false) =
      if (variance) {
        (-8..8).map {
          ((if (critical) this.critical else this.base).toDouble() * (100 + it) / 100).toInt()
        }
      } else {
        listOf(if (critical) this.critical else this.base)
      }
}

data class HitAttribute(
    val modifier: Int = 0,
    val hitCount: Int = 1,
    val attribute: Attribute = Attribute.Neutral,
    val damageType: DamageType = DamageType.Neutral,
    val ampModifier: Int = 100,
    val ampCondition: Condition? = null,
    val addBrilliance: Boolean = true,
    val focus: Boolean = false,
    val noReflect: Boolean = false,
    val noVariance: Boolean = false,
    val mode: HitMode = HitMode.NORMAL,
)

enum class HitMode {
  NORMAL,
  FIXED,
  ELEMENTAL_FIXED,
}
