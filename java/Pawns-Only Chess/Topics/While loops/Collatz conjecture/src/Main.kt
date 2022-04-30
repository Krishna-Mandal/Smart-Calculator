const val ZERO = 0
const val ONE = 1
const val TWO = 2
const val THREE = 3
fun main() {
    var input = readln().toInt()

    while (input != ONE) {
        print(input)
        print(" ")
        when (isEven(input)) {
            true -> input /= TWO
            false -> input = input * THREE + ONE
        }
    }

    print(input)
}

fun isEven(num: Int): Boolean {
    return num % TWO == ZERO
}