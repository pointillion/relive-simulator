package xyz.qwewqa.relive.simulator.core.presets.dress.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.PartialDressBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.StatBoost
import xyz.qwewqa.relive.simulator.core.stage.dress.StatBoostType
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

/*
import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1070017(
    name = "舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("強斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 2
                */
            }
        },
        ActType.Act2.blueprint("奮起の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("呼応の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 11, 12, 13, 15]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("私が守るの、ずっと何度でも") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 挑発・ターゲット固定を無視し、敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: [2, 2, 2, 2, 2]

                field_effects:
                  私たちはもう舞台の上（雲） (value: 1, time: 6, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          ストップ耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          ACTパワーアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
    ),
    unitSkill = null /* 聖翔音楽学園のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1070017 = PartialDressBlueprint(
  id = 1070017,
  name = "舞台少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Nana,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 21040,
  stats = StatData(
    hp = 2842,
    actPower = 205,
    normalDefense = 203,
    specialDefense = 105,
    agility = 164,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 93610,
    actPower = 3380,
    normalDefense = 3350,
    specialDefense = 1740,
    agility = 2700,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters101,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "奮起の斬撃",
      type = ActType.Act2,
      apCost = 3,
      icon = 8,
      parameters = listOf(
        actParameters38,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "呼応の斬撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters38,
        actParameters138,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "私が守るの、ずっと何度でも",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1006,
      parameters = listOf(
        actParameters93,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6600,
      actPower = 510,
      normalDefense = 810,
      specialDefense = 150,
      agility = 360,
    ),
    StatData(
      hp = 11000,
      actPower = 850,
      normalDefense = 1350,
      specialDefense = 250,
      agility = 600,
    ),
    StatData(
      hp = 17600,
      actPower = 1360,
      normalDefense = 2160,
      specialDefense = 400,
      agility = 960,
    ),
    StatData(
      hp = 22000,
      actPower = 1700,
      normalDefense = 2700,
      specialDefense = 500,
      agility = 1200,
    ),
  ),
)
