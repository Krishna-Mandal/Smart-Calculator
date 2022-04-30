const val YES = "YES"
const val NO = "NO"

fun main() {
    val num = readLine()!!.toInt()
    val numList = mutableListOf<Int>()
    val numsToFind = mutableListOf<Int>()

    repeat(num) {
        numList.add(readLine()!!.toInt())
    }

    numsToFind.addAll(readLine()!!.split(" ").map { it.toInt() })

    if (numList.joinToString("").contains(numsToFind.joinToString("")) ||
        numList.joinToString("").contains(numsToFind.joinToString("").reversed())
    ) {
        println(NO)
    } else {
        println(YES)
    }
}
