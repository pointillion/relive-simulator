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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress5010002(
    name = "劉備",
    acts = listOf(
        ActType.Act1.blueprint("刻印の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                刻印
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act2.blueprint("浄化の舞踊") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("逆転の一手") {
            Act {
                /*
                すばやさアップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [20, 22, 24, 27, 30]
                  times1: [3, 3, 3, 3, 3]
                すばやさダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("桃園の誓い") {
            Act {
                /*
                クリティカル率ダウン(%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [20, 22, 24, 27, 30]
                  times1: [3, 3, 3, 3, 3]
                クリティカル威力ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%) (自身のHPが低いほど威力が増加)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [125, 135, 145, 155, 170]
                  times4: 4
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          スタン耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          凍結耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 3:
          ストップ耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress5010002 = PartialDressBlueprint(
  id = 5010002,
  name = "劉備",
  baseRarity = 4,
  cost = 13,
  character = Character.Koharu,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 1142,
    actPower = 244,
    normalDefense = 97,
    specialDefense = 145,
    agility = 220,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 37630,
    actPower = 4030,
    normalDefense = 1600,
    specialDefense = 2400,
    agility = 3630,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "刻印の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 150,
      parameters = listOf(
        actParameters0,
        actParameters23,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "浄化の舞踊",
      type = ActType.Act2,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters46,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "逆転の一手",
      type = ActType.Act3,
      apCost = 3,
      icon = 14,
      parameters = listOf(
        actParameters32,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "桃園の誓い",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 5,
      parameters = listOf(
        actParameters32,
        actParameters32,
        actParameters32,
        actParameters186,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6000,
      actPower = 450,
      normalDefense = 90,
      specialDefense = 300,
      agility = 210,
    ),
    StatData(
      hp = 10000,
      actPower = 750,
      normalDefense = 150,
      specialDefense = 500,
      agility = 350,
    ),
    StatData(
      hp = 16000,
      actPower = 1200,
      normalDefense = 240,
      specialDefense = 800,
      agility = 560,
    ),
    StatData(
      hp = 20000,
      actPower = 1500,
      normalDefense = 300,
      specialDefense = 1000,
      agility = 700,
    ),
  ),
)
