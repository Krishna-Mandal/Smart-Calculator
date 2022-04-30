enum class Rainbow(val color: String) {
    BLUE("blue"),
    ORANGE("orange"),
    RED("red"),
    YELLOW("yellow"),
    GREEN("green"),
    INDIGO("indigo"),
    VIOLET("violet");

    companion object {
        fun isAvailable(color: String): Boolean {
            return values().any { it.color == color }
        }
    }
}
fun main() {
    println(Rainbow.isAvailable(readln()))
}

