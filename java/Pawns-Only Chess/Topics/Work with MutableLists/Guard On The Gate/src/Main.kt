fun main() {
    val backToTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    val returnedWatchman = readLine()!!
    // do not touch the lines above

    val allWatchmen = backToTheWall + returnedWatchman
    println(allWatchmen.joinToString())

}