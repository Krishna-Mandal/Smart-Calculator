const val TWO = 2
const val ONE = 1
const val VOWELS = "aeiouy"
const val CONSONANT = "bcdfghjklmnpqrstvwxz"
fun main() {
    val input = readln()
    var charNeeded = 0
    var index = 0

    while (index < input.length - TWO) {
        val first = input[index]
        val second = input[index + ONE]
        val third = input[index + TWO]
        if (next3IsVowel(first, second, third) ||
            next3IsConsonant(first, second, third)
        ) {
            ++charNeeded
            ++index
        }
        ++index
    }

    println(charNeeded)
}

fun next3IsVowel(first: Char, second: Char, third: Char): Boolean {
    return first in VOWELS && second in VOWELS && third in VOWELS
}

fun next3IsConsonant(first: Char, second: Char, third: Char): Boolean {
    return first in CONSONANT && second in CONSONANT && third in CONSONANT
}