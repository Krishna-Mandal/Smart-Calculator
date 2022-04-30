const val ONE = 1
const val ZERO = 0
fun main() {
    val input = readln().withIndex().toList()
    val list = emptyList<Pair<Char, Int>>().toMutableList()

    var lastInput = input.first().value
    var lastLoc = 0
    var loc = 0
    for (index in input.indices) {
        val currIn = input[index].value
        loc = input[index].index

        if (lastInput != currIn) {
            list.add(lastInput to loc - lastLoc)
            lastLoc = loc
            lastInput = currIn
        }

        if (index == input.lastIndex) {
            list.add(lastInput to loc - lastLoc + ONE)
        }
    }

    list.forEach {
        print("${it.first}${it.second}")
    }
}