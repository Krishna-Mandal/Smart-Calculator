const val ZERO = 0
const val ONE = 1
const val FIRST = ONE - 1
const val TEN = 10
const val TENTH = TEN - 1
const val HUNDRED = 100
const val HUNDREDTH = HUNDRED - 1

fun main() {
    val numbers = MutableList(HUNDRED) { ZERO }
    numbers[FIRST] = ONE
    numbers[TENTH] = TEN
    numbers[HUNDREDTH] = HUNDRED

    // do not touch the lines below 
    println(numbers.joinToString())
}