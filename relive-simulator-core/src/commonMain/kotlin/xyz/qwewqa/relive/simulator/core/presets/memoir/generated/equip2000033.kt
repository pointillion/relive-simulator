package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip2000033 = PartialMemoirBlueprint(
  id = 2000033,
  name = "二人のスタァライト",
  rarity = 2,
  cost = 4,
  baseStats = StatData(
    hp = 105,
    actPower = 0,
    normalDefense = 9,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 16016,
    actPower = 0,
    normalDefense = 1372,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Hikari)
)
