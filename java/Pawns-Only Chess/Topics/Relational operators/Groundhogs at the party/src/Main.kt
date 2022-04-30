const val WEEK_MIN = 10
const val WEEK_MAX = 20
const val WEEKEND_MIN = 15
const val WEEKEND_MAX = 25
fun main() {
    val quantity = readLine()!!.toInt()
    val isWeekend = readLine().toBoolean()

    val weekendSuccess = isWeekend && quantity in WEEKEND_MIN..WEEKEND_MAX
    val weekSuccess = !isWeekend && quantity in WEEK_MIN..WEEK_MAX
    println(weekendSuccess || weekSuccess)
}