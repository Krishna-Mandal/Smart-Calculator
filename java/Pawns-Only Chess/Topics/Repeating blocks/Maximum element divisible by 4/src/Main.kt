const val DIV_BY_4 = 4
fun main() {
    var currentMaxDivisibleBy4 = 0
    repeat(readLine()!!.toInt()) {
        val currentInput = readLine()!!.toInt()
        if (currentInput % DIV_BY_4 == 0 && currentInput > currentMaxDivisibleBy4) {
            currentMaxDivisibleBy4 = currentInput
        }
    }

    println(currentMaxDivisibleBy4)
}