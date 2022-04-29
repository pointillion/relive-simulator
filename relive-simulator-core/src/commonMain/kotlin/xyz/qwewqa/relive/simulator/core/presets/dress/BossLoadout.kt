package xyz.qwewqa.relive.simulator.core.presets.dress

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen.sakuraTaisenStageGirlHikariBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen.sakuraTaisenStageGirlKarenBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.sakurataisen.sakuraTaisenStageGirlMahiruBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.seesawStrategy
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.shinsengumirinpuden.shinsengumiRinpudenKondoIsamiIchieBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.shinsengumirinpuden.shinsengumiRinpudenNagakuraShinpachiFumiBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.seesaw.shinsengumirinpuden.shinsengumiRinpudenOkitaSojiYuyukoBoss
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr10.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr11.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr12.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr13.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr14.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr15.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr16.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr17.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr18.*
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr9.tr9FaithMisora
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr9.tr9FaithMisoraStrategy
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.Strategy

data class BossLoadout(val loadout: ActorLoadout, val strategy: Strategy)

val bossLoadouts = listOf(
    BossLoadout(tr9FaithMisora, tr9FaithMisoraStrategy),
    BossLoadout(tr10DraculaClaudine, tr10DraculaClaudineStrategy),
    BossLoadout(tr10VampireShiori, tr10VampireShioriStrategy),
    BossLoadout(tr10HellsingMichiru, tr10HellsingMichiruStrategy),
    BossLoadout(tr10FaithMisora, tr10FaithMisoraStrategy),
    BossLoadout(tr11CheerAkira, tr11CheerAkiraStrategy),
    BossLoadout(tr11CheerTsukasa, tr11CheerTsukasaStrategy),
    BossLoadout(tr11CheerYachiyo, tr11CheerYachiyoStrategy),
    BossLoadout(tr11FaithMisora, tr11FaithMisoraStrategy),
    BossLoadout(tr12VampireShiori, tr12VampireShioriStrategy),
    BossLoadout(tr12TowerHikari, tr12TowerHikariStrategy),
    BossLoadout(tr13SetsunaIchie, tr13SetsunaIchieStrategy),
    BossLoadout(tr13SetsunaIchieDiff4, tr13SetsunaIchieDiff4Strategy),
    BossLoadout(tr13SuirenYuyuko, tr13SuirenYuyukoStrategy),
    BossLoadout(tr13SuirenYuyukoDiff4, tr13SuirenYuyukoDiff4Strategy),
    BossLoadout(tr13KomachiTamao, tr13KomachiTamaoStrategy),
    BossLoadout(tr13KomachiTamaoDiff4, tr13KomachiTamaoDiff4Strategy),
    BossLoadout(tr13EmperorAkira, tr13EmperorAkiraStrategy),
    BossLoadout(tr13EmperorAkiraDiff4, tr13EmperorAkiraStrategy),
    BossLoadout(tr14MusketeerKaren, tr14MusketeerKarenStrategy),
    BossLoadout(tr14MusketeerKarenDiff4, tr14MusketeerKarenDiff4Strategy),
    BossLoadout(tr14MusketeerHikari, tr14MusketeerHikariStrategy),
    BossLoadout(tr14MusketeerHikariDiff4, tr14MusketeerHikariDiff4Strategy),
    BossLoadout(tr14MusketeerMahiru, tr14MusketeerMahiruStrategy),
    BossLoadout(tr14MusketeerMahiruDiff4, tr14MusketeerMahiruDiff4Strategy),
    BossLoadout(tr14EmperorAkira, tr14EmperorAkiraStrategy),
    BossLoadout(tr14EmperorAkiraDiff4, tr14EmperorAkiraDiff4Strategy),
    BossLoadout(tr15CheerAkira, tr15CheerAkiraStrategy),
    BossLoadout(tr15CheerAkiraDiff4, tr15CheerAkiraDiff4Strategy),
    BossLoadout(tr15CheerTsukasa, tr15CheerTsukasaStrategy),
    BossLoadout(tr15CheerTsukasaDiff4, tr15CheerTsukasaDiff4Strategy),
    BossLoadout(tr15CheerYachiyo, tr15CheerYachiyoStrategy),
    BossLoadout(tr15CheerYachiyoDiff4, tr15CheerYachiyoDiff4Strategy),
    BossLoadout(tr15TowerHikari, tr15TowerHikariStrategy),
    BossLoadout(tr15TowerHikariDiff4, tr15TowerHikariDiff4Strategy),
    BossLoadout(tr16MafiaNana, tr16MafiaNanaStrategy),
    BossLoadout(tr16MafiaNanaDiff4, tr16MafiaNanaDiff4Strategy),
    BossLoadout(tr16MafiaMaya, tr16MafiaMayaStrategy),
    BossLoadout(tr16MafiaMayaDiff4, tr16MafiaMayaDiff4Strategy),
    BossLoadout(tr16MafiaKaoruko, tr16MafiaKaorukoStrategy),
    BossLoadout(tr16MafiaKaorukoDiff4, tr16MafiaKaorukoDiff4Strategy),
    BossLoadout(tr16HangedManRui, tr16HangedManRuiStrategy),
    BossLoadout(tr16BuggedHangedManRui, tr16BuggedHangedManRuiStrategy),
    BossLoadout(tr16HangedManRuiDiff4, tr16HangedManRuiDiff4Strategy),
    BossLoadout(tr17DraculaClaudine, tr17DraculaClaudineStrategy),
    BossLoadout(tr17DraculaClaudineDiff4, tr17DraculaClaudineDiff4Strategy),
    BossLoadout(tr17VampireShiori, tr17VampireShioriStrategy),
    BossLoadout(tr17VampireShioriDiff4, tr17VampireShioriDiff4Strategy),
    BossLoadout(tr17HellsingMichiru, tr17HellsingMichiruStrategy),
    BossLoadout(tr17HellsingMichiruDiff4, tr17HellsingMichiruDiff4Strategy),
    BossLoadout(tr17FaithMisora, tr17FaithMisoraStrategy),
    BossLoadout(tr17FaithMisoraDiff4, tr17FaithMisoraDiff4Strategy),
    BossLoadout(tr18WhiteRabbitMisora, tr18WhiteRabbitMisoraStrategy),
    BossLoadout(tr18WhiteRabbitMisoraDiff4, tr18WhiteRabbitMisoraDiff4Strategy),
    BossLoadout(tr18AliceAruru, tr18AliceAruruStrategy),
    BossLoadout(tr18AliceAruruDiff4, tr18AliceAruruDiff4Strategy),
    BossLoadout(tr18QueenOfHeartsShizuha, tr18QueenOfHeartsShizuhaStrategy),
    BossLoadout(tr18QueenOfHeartsShizuhaDiff4, tr18QueenOfHeartsShizuhaDiff4Strategy),
    BossLoadout(tr18EmperorAkira, tr18EmperorAkiraStrategy),
    BossLoadout(tr18EmperorAkiraDiff4, tr18EmperorAkiraDiff4Strategy),
    BossLoadout(sakuraTaisenStageGirlKarenBoss, seesawStrategy),
    BossLoadout(sakuraTaisenStageGirlHikariBoss, seesawStrategy),
    BossLoadout(sakuraTaisenStageGirlMahiruBoss, seesawStrategy),
    BossLoadout(shinsengumiRinpudenKondoIsamiIchieBoss, seesawStrategy),
    BossLoadout(shinsengumiRinpudenNagakuraShinpachiFumiBoss, seesawStrategy),
    BossLoadout(shinsengumiRinpudenOkitaSojiYuyukoBoss, seesawStrategy),
).associateBy { it.loadout.name }
