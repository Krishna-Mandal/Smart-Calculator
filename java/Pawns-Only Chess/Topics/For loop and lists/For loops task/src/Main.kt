const val YES = "YES"
const val NO = "NO"
fun main() {
    val num = readLine()!!.toInt()
    val numList = mutableListOf<Int>()
    repeat(num) {
        numList.add(readLine()!!.toInt())
    }

    val (firstNumToSearch, secondNumberToSearch) = readLine()!!.split(" ").map { it.toInt() }

    if (numList.containsAll(mutableListOf(firstNumToSearch, secondNumberToSearch))) {
        println(YES)
    } else {
        println(NO)
    }
}