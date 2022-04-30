fun main() {
    var positiveNo = 0
    repeat(readLine()!!.toInt()) {
        if (readLine()!!.toInt() > 0) {
            ++positiveNo
        }
    }
    println(positiveNo)
}