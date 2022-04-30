const val NUMERIC = "\\d"

fun main() {
    val input = readln()
    val regex = Regex(NUMERIC)

    for (char in input.toCharArray()) {
        if (regex.matches(char.toString())) {
            println(char)
            break
        }
    }
}