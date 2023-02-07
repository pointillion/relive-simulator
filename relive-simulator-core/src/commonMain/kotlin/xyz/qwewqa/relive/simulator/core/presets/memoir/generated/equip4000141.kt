package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000141 = PartialMemoirBlueprint(
  id = 4000141,
  name = "ライオンズ×まひる",
  rarity = 4,
  cost = 12,
  baseStats = StatData(
    hp = 260,
    actPower = 163,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 60000,
    actPower = 3000,
    normalDefense = 0,
    specialDefense = 0,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(2, 2, 2, 2, 1),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(5000, 5000, 6000, 7500, 10000),
        times = listOf(0, 0, 0, 0, 0),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
    ),
  ),
  additionalTags = listOf(EffectTag.Mahiru)
)
