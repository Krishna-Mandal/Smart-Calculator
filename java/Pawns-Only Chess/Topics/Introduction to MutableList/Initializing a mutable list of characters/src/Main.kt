const val A = 'a'
const val Z = 'z'
const val E = 'e'
const val D = 'd'

fun main() {
    val characters = mutableListOf(A, Z, E, D)

    println(characters.joinToString())
}