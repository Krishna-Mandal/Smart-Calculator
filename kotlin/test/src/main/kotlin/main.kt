fun main() {

    val numbers1 = mutableListOf<Int>(1, 2, 3, 4)
    val numbers2 = mutableListOf<Int>(1, 2, 3, 4)
    val numbers3 = mutableListOf<Int>(4, 3, 2, 1)
    val numbers4 = mutableListOf<Int>(1, 2, 3)

    println(numbers2 == numbers3)

    println(numbers1 == numbers2)

    println(numbers4 == numbers2)

    println(numbers1 == numbers1)
}