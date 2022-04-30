fun main() {
    var input: Int
    var sum = 0
    do {
        input = readln().toInt()
        sum += input
    } while (input != 0)

    println(sum)
}