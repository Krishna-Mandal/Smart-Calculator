val ALPHABET = ('a'..'z').toSet()
fun main() {
    println((ALPHABET - readln().toSet()).joinToString(separator = ""))
}