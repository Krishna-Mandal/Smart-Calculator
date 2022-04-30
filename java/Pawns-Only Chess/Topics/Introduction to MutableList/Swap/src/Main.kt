fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
    // Do not touch lines above
    val temp = numbers.first()
    val firstIndex = numbers.indexOfFirst { it == temp }
    numbers[firstIndex] = numbers[numbers.lastIndex]
    numbers[numbers.lastIndex] = temp

    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}