package xyz.qwewqa.relivesim.stage

/**
 * Value class representing a percentage value.
 */
@JvmInline
value class Percent(val value: Double) {
    operator fun times(other: Percent) = Percent(this.asDouble() * other.value)
    operator fun div(other: Percent) = Percent(this.value / other.asDouble())
    operator fun plus(other: Percent) = Percent(this.value + other.value)
    operator fun minus(other: Percent) = Percent(this.value - other.value)

    operator fun unaryPlus() = this
    operator fun unaryMinus() = Percent(-this.value)
}

inline val Int.percent get() = Percent(this.toDouble())
inline val Double.percent get() = Percent(this)

fun Double.asPercent() = Percent(this * 100.0)
fun Percent.asDouble() = this.value / 100.0

operator fun Int.times(percent: Percent) = this * percent.asDouble()
operator fun Double.times(percent: Percent) = this * percent.asDouble()

operator fun Percent.times(int: Int) = this.asDouble() * int
operator fun Percent.times(double: Double) = this.asDouble() * double

fun Percent.coerceAtMost(maximumValue: Percent): Percent {
    return Percent(value.coerceAtMost(maximumValue.value))
}

fun Percent.coerceAtLeast(minimumValue: Percent): Percent {
    return Percent(value.coerceAtLeast(minimumValue.value))
}

fun Percent.coerceIn(minimumValue: Percent, maximumValue: Percent): Percent {
    return Percent(value.coerceIn(minimumValue.value, maximumValue.value))
}
