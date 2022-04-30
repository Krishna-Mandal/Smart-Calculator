const val ZERO = 0
const val ONE = 1
fun main() {
    val inputList = readLine()!!.split(" ")
    println("${inputList[ZERO].first()}. ${inputList[ONE]}, ${inputList.last()} years old")

}