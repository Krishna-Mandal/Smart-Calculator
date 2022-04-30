const val TWO = 2
fun main() {
    val inputList = mutableListOf<String>()
    repeat(TWO) {
        inputList.add(readLine()!!)
    }

    println(inputList.first() == inputList.last())
}