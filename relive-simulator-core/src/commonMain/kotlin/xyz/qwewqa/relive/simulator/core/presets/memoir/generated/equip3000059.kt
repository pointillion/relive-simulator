package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip3000059 = PartialMemoirBlueprint(
  id = 3000059,
  name = "摩訶不思議なリサイクルショップ",
  rarity = 3,
  cost = 6,
  baseStats = StatData(
    hp = 0,
    actPower = 6,
    normalDefense = 12,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 821,
    normalDefense = 1643,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Michiru, EffectTag.MeiFan)
)
