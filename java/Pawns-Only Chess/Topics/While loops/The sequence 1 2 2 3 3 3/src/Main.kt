const val ZERO = 0
const val ONE = 1

fun main() {
    val input = readln().toInt()
    val numList = mutableListOf<Int>()
    var tmpIn = ONE
    while (numList.size < input) {
        repeat(tmpIn) {
            numList.add(tmpIn)
        }
        tmpIn++
    }

    println(numList.subList(ZERO, input).joinToString(separator = " "))
}
