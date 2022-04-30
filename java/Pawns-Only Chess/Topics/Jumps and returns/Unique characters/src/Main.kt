fun main() {
    val input = readln()
    val freqMap = input.groupBy { it }
    println(freqMap.filter { it.value.size == 1 }.size)
}