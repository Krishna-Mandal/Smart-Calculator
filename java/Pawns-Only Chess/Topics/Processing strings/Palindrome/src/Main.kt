const val YES = "yes"
const val NO = "no"

fun main() {
    val input = readln()

    if (input == input.reversed()) {
        println(YES)
    } else {
        println(NO)
    }

}