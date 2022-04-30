@SuppressWarnings("MagicNumber")
enum class DangerLevel(val howMuch: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel(): Int {
        return this.howMuch
    }
}