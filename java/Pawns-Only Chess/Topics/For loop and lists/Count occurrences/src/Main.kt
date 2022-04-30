fun main() {
    val num = readLine()!!.toInt()
    val numList = mutableListOf<Int>()
    repeat(num) {
        numList.add(readLine()!!.toInt())
    }
    val numToFind = readLine()!!.toInt()

    println(numList.filter { it.equals(numToFind) }.size)
}