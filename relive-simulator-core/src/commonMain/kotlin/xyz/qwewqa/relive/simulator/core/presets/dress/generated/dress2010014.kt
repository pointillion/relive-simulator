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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2010014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2010014(
    name = "土方歳三",
    acts = listOf(
        ActType.Act1.blueprint("浄化の薙払") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [84, 88, 92, 97, 101]
                  times3: 1
                */
            }
        },
        ActType.Act2.blueprint("キラめきの風") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [15, 16, 17, 18, 20]
                  times1: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("型破りの剣") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 1

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("茨掻き") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [200, 210, 220, 230, 240]
                  times2: 3
                ストップ
                  target: 敵役全体
                  hit_rate3: 75
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          AP増加
            target: 前から5体の敵役
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 2:
          スタン
            target: 前から5体の敵役
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 50
            time: 0
        */
        ),
    ),
    unitSkill = null /* 月・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2010014 = PartialDressBlueprint(
  id = 2010014,
  name = "土方歳三",
  baseRarity = 4,
  cost = 13,
  character = Character.Tamao,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1282,
    actPower = 243,
    normalDefense = 87,
    specialDefense = 137,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 50000,
    actPower = 3700,
    normalDefense = 1500,
    specialDefense = 2200,
    agility = 3600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "浄化の薙払",
      type = ActType.Act1,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters30,
        actParameters53,
        actParameters136,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの風",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters34,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "型破りの剣",
      type = ActType.Act3,
      apCost = 2,
      icon = 1022,
      parameters = listOf(
        actParameters21,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "茨掻き",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 60,
      parameters = listOf(
        actParameters30,
        actParameters57,
        actParameters139,
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
      hp = 4800,
      actPower = 540,
      normalDefense = 90,
      specialDefense = 300,
      agility = 210,
    ),
    StatData(
      hp = 8000,
      actPower = 900,
      normalDefense = 150,
      specialDefense = 500,
      agility = 350,
    ),
    StatData(
      hp = 12800,
      actPower = 1440,
      normalDefense = 240,
      specialDefense = 800,
      agility = 560,
    ),
    StatData(
      hp = 16000,
      actPower = 1800,
      normalDefense = 300,
      specialDefense = 1000,
      agility = 700,
    ),
  ),
)
