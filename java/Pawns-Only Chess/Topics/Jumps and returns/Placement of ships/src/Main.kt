const val ONE = 1
const val NUM_IP = 3
const val NUM_SHIPS = 5

fun main() {
    val rowSet = (ONE..NUM_SHIPS).toSet()
    val colSet = (ONE..NUM_SHIPS).toSet()

    val rowSetIn = mutableSetOf<Int>()
    val colSetIn = mutableSetOf<Int>()

    repeat(NUM_IP) {
        val input = readln().split(" ").map { it.toString().toInt() }
        rowSetIn.add(input.first())
        colSetIn.add(input.last())
    }

    println((rowSet - rowSetIn).joinToString(separator = " "))
    println((colSet - colSetIn).joinToString(separator = " "))

}