const val MIN: Byte = 1
const val MAX: Byte = 3
fun main() {
    var byte: Byte = 0
    for (index in MIN..MAX) {
        if (readLine()!!.toInt() > 0) {
            ++byte
        }
    }
    println(byte == MIN)
}