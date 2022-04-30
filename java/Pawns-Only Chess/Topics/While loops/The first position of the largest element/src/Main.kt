import java.util.*

fun main() {
    var largestNum = Int.MIN_VALUE
    var index = 0
    var loc = 0
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val currVal = scanner.nextInt()
        loc++
        if (currVal > largestNum) {
            largestNum = currVal
            index = loc
        }
    }

    println("$largestNum $index")
}