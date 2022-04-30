const val ONE = 1
fun main() {
    val inputString = readLine().toString()
    val inputNumber = readLine()!!.toInt()
    val result = inputString[inputNumber - ONE]

    println("Symbol # $inputNumber of the string \"$inputString\" is '$result'")
}