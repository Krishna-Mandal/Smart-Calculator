const val FIRST_INDEX = 0
const val SECOND_INDEX = 1
fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
    // do not touch the lines above

    numbers.add(FIRST_INDEX, numbers.sum())
    numbers.removeAt(numbers.lastIndex - SECOND_INDEX)
    println(numbers.joinToString(" "))
}