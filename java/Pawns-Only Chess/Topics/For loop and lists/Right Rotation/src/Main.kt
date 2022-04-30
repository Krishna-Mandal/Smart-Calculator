const val INDEX_O = 0
const val INDEX_1 = 1
fun main() {
    val numOfElements = readLine()!!.toInt()
    val numList = mutableListOf<Int>()

    for (index in INDEX_O until numOfElements) {
        numList.add(readLine()!!.toInt())
    }

    val numOfRotations = readLine()!!.toInt() % numOfElements

    for (numOfRotation in numOfRotations downTo 1) {
        val lastElement = numList.last()
        numList.removeAt(numOfElements - INDEX_1)
        numList.add(0, lastElement)
    }

    println(numList.joinToString(" "))
}
