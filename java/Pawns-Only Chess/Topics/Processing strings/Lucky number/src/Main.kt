const val ZERO = 0
const val TWO = 2
const val YES = "YES"
const val NO = "NO"

fun main() {
    val input = readln()
    val inputFirstHalf = input.substring(ZERO, input.length / TWO)

    if (input.toCharArray().sumOf { it.toString().toInt() }
        == inputFirstHalf.toCharArray().sumOf { it.toString().toInt() } * TWO
    ) {
        println(YES)
    } else {
        println(NO)
    }
}