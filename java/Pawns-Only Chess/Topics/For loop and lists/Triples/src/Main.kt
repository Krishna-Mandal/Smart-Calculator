const val ZERO = 0
const val ONE = 1
const val TWO = 2
const val RANGE = 9

fun main() {
    val num = readLine()!!.toInt()
    val numList = mutableListOf<String>()
    var found = ZERO

    repeat(num) {
        numList.add(readLine()!!.toString())
    }

    val tripeStringList = triplesList(RANGE)

    for (triples in tripeStringList) {
        if (triples in numList.joinToString()) {
            ++found
        }
    }

    println(found)
}

fun triplesList(range: Int): MutableList<String> {
    val tripleNumbers = mutableListOf<Int>()
    tripleNumbers.addAll((ZERO..range).toList())
    val tripleStrings = mutableListOf<String>()
    for (index in 0..range - TWO) {
        tripleStrings.add(tripleNumbers.slice(index..index + 2).joinToString())
    }

    return tripleStrings
}