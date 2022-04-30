fun main() {
    val input = readln()
    val first = input.first()
    val last = input.last()

    println(last + input.substring(1, input.length - 1) + first)
}