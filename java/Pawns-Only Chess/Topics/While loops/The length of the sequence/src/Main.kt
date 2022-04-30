fun main() {
    var input: Int
    var count = 0
    do {
        input = readln().toInt()
        count++
    } while (input != 0)

    println(--count)
}