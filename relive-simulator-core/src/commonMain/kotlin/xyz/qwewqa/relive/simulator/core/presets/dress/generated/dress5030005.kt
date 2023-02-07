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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5030005
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress5030005(
    name = "白雪姫の女王",
    acts = listOf(
        ActType.Act1.blueprint("冷酷な眼差し") {
            Act {
                /*
                AP減少
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [170, 180, 190, 200, 210]
                  times3: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("黒魔術") {
            Act {
                /*
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [170, 180, 190, 200, 210]
                  times3: 1

                field_effects:
                  拍手喝采（風） (value: 1, time: 6, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("嫉妬と羨望") {
            Act {
                /*
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [30, 30, 30, 30, 30]
                  times1: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [3, 3, 3, 3, 3]
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [170, 180, 190, 200, 210]
                  times4: 1

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                  美しく、気高く、楽しく (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("giftigen Apfel") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                毒(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [99999, 99999, 99999, 99999, 99999]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率でストップを1ターン付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate3: 100
                  values3: [650, 660, 670, 680, 700]
                  times3: [10, 10, 10, 10, 10]

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                  災禍の呼び声 (value: 1, time: 2, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 4
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          祝福[有利属性ダメージアップ](%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          クリティカル率アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          クリティカル威力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          継続マイナス効果耐性アップ(%value%)
            target: 味方の風属性
            hit_rate: 100
            value: 100
            time: 3
          AP減少2
            target: 味方の風属性
            hit_rate: 100
            value: 0
            time: 1

          field_effects:
            遅疑逡巡 (value: 1, time: 2, target: enemies)
        */
        ),
        listOf(
        /*
        auto skill 3:
          誓いのレヴュー特攻(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
        */
        ),
        listOf(
        /*
        auto skill 4:
          ACTパワーアップ(%value%) (自身のHPが最大時に発動)
            target: 自身
            values: [100, 100, 100, 100, 100]
          毎ターンHP回復(%value%)
            target: 自身
            values: [20000, 20000, 20000, 20000, 20000]
        */
        ),
    ),
    unitSkill = null /* 風・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress5030005 = PartialDressBlueprint(
  id = 5030005,
  name = "白雪姫の女王",
  baseRarity = 4,
  cost = 23,
  character = Character.Hisame,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14500,
    actPower = 870,
    normalDefense = 570,
    specialDefense = 1150,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 87400,
    actPower = 5810,
    normalDefense = 2900,
    specialDefense = 3800,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "冷酷な眼差し",
      type = ActType.Act1,
      apCost = 2,
      icon = 1044,
      parameters = listOf(
        actParameters14,
        actParameters30,
        actParameters66,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "黒魔術",
      type = ActType.Act2,
      apCost = 2,
      icon = 1037,
      parameters = listOf(
        actParameters62,
        actParameters30,
        actParameters66,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "嫉妬と羨望",
      type = ActType.Act3,
      apCost = 2,
      icon = 1061,
      parameters = listOf(
        actParameters63,
        actParameters63,
        actParameters30,
        actParameters66,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "giftigen Apfel",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1023,
      parameters = listOf(
        actParameters30,
        actParameters394,
        actParameters278,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9900,
      actPower = 510,
      normalDefense = 540,
      specialDefense = 600,
      agility = 60,
    ),
    StatData(
      hp = 16500,
      actPower = 850,
      normalDefense = 900,
      specialDefense = 1000,
      agility = 100,
    ),
    StatData(
      hp = 26400,
      actPower = 1360,
      normalDefense = 1440,
      specialDefense = 1600,
      agility = 160,
    ),
    StatData(
      hp = 33000,
      actPower = 1700,
      normalDefense = 1800,
      specialDefense = 2000,
      agility = 200,
    ),
  ),
)
