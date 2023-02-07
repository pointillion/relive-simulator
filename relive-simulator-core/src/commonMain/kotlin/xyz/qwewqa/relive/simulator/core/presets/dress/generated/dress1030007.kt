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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030007(
    name = "モリアーティ教授",
    acts = listOf(
        ActType.Act1.blueprint("打撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("キラめきの大盾") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
                特殊バリア(%value%)
                  target: 後ろから2体の味方
                  hit_rate2: 100
                  values2: [300, 510, 840, 1390, 2120]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("敏速の歌") {
            Act {
                /*
                すばやさアップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [42, 47, 51, 56, 60]
                  times1: [3, 3, 3, 3, 3]
                特殊防御力アップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [18, 20, 22, 24, 26]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("闇夜の完全犯罪") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [146, 153, 161, 168, 175]
                  times1: 2
                ターゲット固定
                  target: 後ろから3体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                被ダメージダウン(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [21, 23, 25, 27, 30]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          被ダメージダウン(%value%)
            target: 自身
            values: [4, 4, 5, 5, 6]
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
          特殊バリア(%value%)
            target: 自身
            hit_rate: 100
            value: 2270
            time: 3
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX60%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030007 = PartialDressBlueprint(
  id = 1030007,
  name = "モリアーティ教授",
  baseRarity = 4,
  cost = 12,
  character = Character.Mahiru,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11040,
  stats = StatData(
    hp = 1783,
    actPower = 96,
    normalDefense = 95,
    specialDefense = 135,
    agility = 131,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 58760,
    actPower = 1580,
    normalDefense = 1570,
    specialDefense = 2230,
    agility = 2160,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "打撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの大盾",
      type = ActType.Act2,
      apCost = 2,
      icon = 31,
      parameters = listOf(
        actParameters3,
        actParameters126,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "敏速の歌",
      type = ActType.Act3,
      apCost = 2,
      icon = 14,
      parameters = listOf(
        actParameters127,
        actParameters128,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "闇夜の完全犯罪",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 152,
      parameters = listOf(
        actParameters129,
        actParameters14,
        actParameters130,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard0,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 300,
      normalDefense = 300,
      specialDefense = 510,
      agility = 240,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 500,
      specialDefense = 850,
      agility = 400,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 800,
      specialDefense = 1360,
      agility = 640,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1000,
      specialDefense = 1700,
      agility = 800,
    ),
  ),
)
