const val G = "g"
const val C = "c"
const val CENT = 100

fun main() {
    val input = readln()
    println(input.count { it.lowercase() == G || it.lowercase() == C }.toDouble() / input.length.toDouble() * CENT)
}