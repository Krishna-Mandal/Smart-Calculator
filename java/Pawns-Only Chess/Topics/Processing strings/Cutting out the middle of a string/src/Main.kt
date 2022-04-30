const val TWO = 2
const val ZERO = 0
const val ONE = 1

fun main() {
    val input = readln()
    val lowMid: Int
    val highMid: Int

    if (input.length % TWO == ZERO) {
        lowMid = input.length / TWO - ONE
        highMid = lowMid + TWO
    } else {
        lowMid = input.lastIndex / TWO
        highMid = lowMid + ONE
    }

    println(input.substring(ZERO, lowMid) + input.substring(highMid))

}