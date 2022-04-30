fun main() {
    val (hr, min, sec) = readLine()!!.split(" ")
    val (day, mon, year) = readLine()!!.split(" ")

    println("$hr:$min:$sec $day/$mon/$year")
}