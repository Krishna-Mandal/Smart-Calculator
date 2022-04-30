fun main() {
    val report = readln()
    val regex = Regex(". wrong answers?")
    println(report.matches(regex))
}