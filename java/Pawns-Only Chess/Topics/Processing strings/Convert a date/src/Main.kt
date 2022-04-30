import java.util.*

fun main() {
    val inputList = readln().split("-")
    Collections.rotate(inputList, -1)
    println(inputList.joinToString(separator = "/"))
}