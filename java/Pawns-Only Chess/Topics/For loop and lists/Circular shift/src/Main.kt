const val ONE = 1
const val ZERO = 0
fun main() {
    val numList = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }

    val lastElement = numList.last()
    for (index in numList.size - ONE downTo ONE) {
        numList[index] = numList[index - ONE]
    }
    numList[ZERO] = lastElement

    println(numList.joinToString(" "))
}