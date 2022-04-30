const val SUM = 20
fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    println(a + b == SUM || b + c == SUM || a + c == SUM)
}