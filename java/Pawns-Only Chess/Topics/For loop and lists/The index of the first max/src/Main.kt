fun main() {
    val num = readLine()!!.toInt()
    val numList = mutableListOf<Int>()
    repeat(num) {
        numList.add(readLine()!!.toInt())
    }

    println(numList.indexOf(numList.maxOrNull()))
}