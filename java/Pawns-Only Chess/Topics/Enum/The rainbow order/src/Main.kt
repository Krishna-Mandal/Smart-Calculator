@SuppressWarnings("MagicNumber")
enum class Rainbow(val order: Int, val color: String) {
    NULL(0, ""),
    RED(1, "red"),
    ORANGE(2, "orange"),
    YELLOW(3, "yellow"),
    GREEN(4, "green"),
    BLUE(5, "blue"),
    INDIGO(6, "indigo"),
    VIOLET(7, "violet");

    companion object {
        fun getColorNumber(color: String): Int {
            return values().first { it.color == color }.order
        }
    }

}
fun main() {
    val color = readLine()!!
    println(Rainbow.getColorNumber(color))
}