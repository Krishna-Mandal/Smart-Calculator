import java.util.*

const val ZERO = 0
fun main() {
    val (input, num) = readln().split(" ")
    val actualInput = input.toList().reversed()
    Collections.rotate(
        actualInput,
        if (num.toInt() <= actualInput.size) {
            num.toInt()
        } else {
            ZERO
        }
    )
    println(actualInput.reversed().joinToString(separator = ""))
}