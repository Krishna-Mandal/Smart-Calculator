fun main() {
    var input: Int
    var largest = 0
    do {
        input = readln().toInt()
        if (input > largest) {
            largest = input
        }
    } while (input != 0)

    println(largest)
}