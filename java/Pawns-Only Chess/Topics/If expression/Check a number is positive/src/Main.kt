const val YES = "YES"
const val NO = "NO"

fun main(args: Array<String>) {
    val input = readLine()?.toInt()
    if (input != null && input > 0) {
        println(YES)
    } else {
        println(NO)
    }
}
