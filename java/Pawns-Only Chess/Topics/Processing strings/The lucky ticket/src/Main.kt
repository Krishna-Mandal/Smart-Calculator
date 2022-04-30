const val LUCKY = "Lucky"
const val REGULAR = "Regular"
const val FIRST = 0
const val MID = 3
const val LAST = 6
fun main() {
    val input = readln()

    if (input.substring(FIRST, MID).toCharArray().sumOf { it.toString().toInt() } ==
        input.substring(MID, LAST).toCharArray().sumOf { it.toString().toInt() }
    ) {
        println(LUCKY)
    } else {
        println(REGULAR)
    }
}