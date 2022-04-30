private const val ZERO = 0
fun main() {
    val (upperCase, lowerCase, numbers, total) = readln().split(" ").map { it.toInt() }.toList()
    val pswd = (
            MutableList(upperCase) { ('A'..'Z').random() } +
                    MutableList(lowerCase) { ('a'..'z').random() } +
                    MutableList(numbers) { ('0'..'9').random() } +
                    MutableList(total - (upperCase + lowerCase + numbers)) { ('!'..'~').random() }
            ).toCharArray()

    while (repeatSymbol(String(pswd))) {
        pswd.shuffle()
    }
    println(pswd)
}

fun repeatSymbol(str: String): Boolean {
    for (index in ZERO until str.lastIndex) {
        if (str[index] == str[index + 1]) {
            return true
        }
    }
    return false
}
