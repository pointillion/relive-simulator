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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020022
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1020022(
    name = "シャーロック",
    acts = listOf(
        ActType.Act1.blueprint("雷鳴の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                毎ターン継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [3, 3, 3, 3, 3]

                field_effects:
                  雷鳴 (value: 1, time: 2, target: enemies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("封印の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                AP増加
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]

                field_effects:
                  プラス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("輝く斬撃") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [40, 40, 40, 40, 40]
                  times1: [0, 0, 0, 0, 0]
                回数マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                AP減少
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("トイズ～サイコキネシス～") {
            Act {
                /*
                圧倒
                  target: 敵役の次のACT実行者
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [200, 210, 220, 230, 240]
                  times3: 3
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [50, 50, 50, 50, 50]
                  times4: [1, 1, 1, 1, 1]
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate5: 100
                  values5: [500000, 500000, 500000, 500000, 500000]
                  times5: [2, 2, 2, 2, 2]

                field_effects:
                  迷宮入りの予感 (value: 1, time: 2, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 100
            time: 1
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
        */
        ),
        listOf(
        /*
        auto skill 2:
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          回数マイナス効果耐性アップ(%value%) (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 0
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
          継続マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          感電(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 7500
            time: 1
          混乱
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1

          field_effects:
            甘き堕落 (value: 1, time: 2, target: enemies)
        */
        ),
        listOf(
        /*
        auto skill 4:
          毎ターン継続マイナス効果解除
            target: 自身
            values: [0, 0, 0, 0, 0]
          毎ターン回数マイナス効果解除
            target: 自身
            values: [0, 0, 0, 0, 0]
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress1020022 = PartialDressBlueprint(
  id = 1020022,
  name = "シャーロック",
  baseRarity = 4,
  cost = 23,
  character = Character.Hikari,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14300,
    actPower = 880,
    normalDefense = 560,
    specialDefense = 1160,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 87000,
    actPower = 5800,
    normalDefense = 2900,
    specialDefense = 3800,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "雷鳴の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1012,
      parameters = listOf(
        actParameters44,
        actParameters23,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "封印の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1060,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters14,
        actParameters14,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "輝く斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 1026,
      parameters = listOf(
        actParameters70,
        actParameters53,
        actParameters14,
        actParameters44,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "トイズ～サイコキネシス～",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1075,
      parameters = listOf(
        actParameters25,
        actParameters108,
        actParameters57,
        actParameters67,
        actParameters109,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard5,
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
