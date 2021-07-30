package xyz.qwewqa.relivesim.stage

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

data class Stage(
    val playerCharacters: List<CharacterState>,
    val enemyCharacters: List<CharacterState>,
    val playerCACount: Int = 0,
    val configuration: StageConfiguration = StageConfiguration(),
) {
    val logger = Logger()

    val activePlayerCharacters get() = playerCharacters.filter { it.alive }
    val activeEnemyCharacters get() = enemyCharacters.filter { it.alive }
}

@OptIn(ExperimentalContracts::class)
inline fun Stage.log(tag: String = "", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    if (configuration.logging) {
        logger.log(tag, value())
    }
}