const val TIMES_2 = 2
fun main() {
    println(readln().toCharArray().joinToString(separator = "", transform = { it.toString().repeat(TIMES_2) }))
}