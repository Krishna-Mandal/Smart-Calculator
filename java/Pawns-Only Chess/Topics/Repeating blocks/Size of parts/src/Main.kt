const val LARGER = 1
const val SMALLER = -1
fun printDetection() {
    var needFix = 0
    var reject = 0
    var ok = 0
    repeat(readLine()!!.toInt()) {
        val currentIn = readLine()!!.toInt()
        if (currentIn == LARGER) {
            ++needFix
        } else if (currentIn == SMALLER) {
            ++reject
        } else {
            ++ok
        }
    }

    println("$ok $needFix $reject")
}

fun main() {
    printDetection()
}