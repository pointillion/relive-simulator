package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.gen.valuesGenSkillFieldEffect
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry

enum class SkillFieldEffectTarget {
  Allies,
  Enemies,
}

data class SkillFieldEffectOption(
    val option: FieldEffectOption,
    val value: Int,
    val time: Int,
    val target: SkillFieldEffectTarget,
) {
  fun execute(context: ActionContext) {
    context.executeFieldEffectOption(option = option, target = target, value = value, time = time)
  }
}

interface SkillFieldEffect : FeatureImplementation {
  val options: List<SkillFieldEffectOption>

  fun execute(context: ActionContext) {
    options.forEach { it.execute(context) }
  }
}

object SkillFieldEffects : ImplementationRegistry<SkillFieldEffect>() {
  private fun getSkillFieldEffectOption(
      optionId: Int,
      targetType: Int,
      time: Int,
      value: Int
  ): SkillFieldEffectOption? {
    return SkillFieldEffectOption(
        option = FieldEffectOptions[optionId] ?: return null,
        value = value,
        time = time,
        target =
            when (targetType) {
              1 -> SkillFieldEffectTarget.Allies
              2 -> SkillFieldEffectTarget.Enemies
              else -> error("Invalid target type $targetType")
            })
  }

  init {
    for ((id, effect) in valuesGenSkillFieldEffect) {
      +object : SkillFieldEffect {
        override val id = id
        override val options =
            listOfNotNull(
                getSkillFieldEffectOption(
                    effect.option1_id,
                    effect.option1_target_type,
                    effect.option1_time,
                    effect.option1_value),
                getSkillFieldEffectOption(
                    effect.option2_id,
                    effect.option2_target_type,
                    effect.option2_time,
                    effect.option2_value),
                getSkillFieldEffectOption(
                    effect.option3_id,
                    effect.option3_target_type,
                    effect.option3_time,
                    effect.option3_value),
                getSkillFieldEffectOption(
                    effect.option4_id,
                    effect.option4_target_type,
                    effect.option4_time,
                    effect.option4_value),
                getSkillFieldEffectOption(
                    effect.option5_id,
                    effect.option5_target_type,
                    effect.option5_time,
                    effect.option5_value),
            )
      }
    }
  }
}
