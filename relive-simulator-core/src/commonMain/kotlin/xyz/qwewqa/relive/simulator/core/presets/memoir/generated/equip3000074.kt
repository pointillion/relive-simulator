package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip3000074 = PartialMemoirBlueprint(
  id = 3000074,
  name = "元気の素を召し上がれ",
  rarity = 3,
  cost = 6,
  baseStats = StatData(
    hp = 147,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 12,
  ),
  growthStats = StatData(
    hp = 19173,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 1643,
  ),
  additionalTags = listOf(EffectTag.Michiru)
)
