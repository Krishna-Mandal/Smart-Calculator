const val PERCENT = 100.00f
const val ZERO = 0
const val DELTA = 0.000001
const val ONE = 1
fun main() {
    val num = readLine()!!.toInt()
    val incomes = MutableList(num) { readLine()!!.toFloat() }
    val taxes = MutableList(num) { readLine()!!.toFloat() }
    val netTax = mutableListOf<Float>()

    for (index in ZERO until num) {
        netTax.add(incomes[index] * taxes[index] / PERCENT)
    }

    if (num != 0) {
        val highestTax = netTax.filter { equal(it, netTax.maxOrNull()!!) }.first()
        println(netTax.indexOf(highestTax) + ONE)
    } else {
        println(ZERO)
    }
}

fun equal(val1: Float, val2: Float): Boolean {
    if (val1 - val2 >= ZERO && val1 - val2 < DELTA ||
        val2 - val1 >= ZERO && val2 - val1 < DELTA
    ) {
        return true
    }
    return false
}