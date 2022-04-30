const val ZERO = 0
const val YES = "YES"
const val NO = "NO"

fun main() {
    val num = readLine()!!.toInt()
    val numList = mutableListOf<Int>()

    repeat(num) {
        numList.add(readLine()!!.toInt())
    }

    val numToFind = readLine()!!.toInt()

    val found = numList.filter { it == numToFind }.size > ZERO

    if (found) {
        println(YES)
    } else {
        println(NO)
    }
}
