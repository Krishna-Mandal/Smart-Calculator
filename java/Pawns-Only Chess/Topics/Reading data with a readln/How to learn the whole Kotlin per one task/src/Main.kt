const val MAX_SIZE = 5
fun main() {
    var count = MAX_SIZE
    var inStr = ""
    while (count > 0) {
        inStr += " " + readLine()
        count--
    }

    println(inStr)
}