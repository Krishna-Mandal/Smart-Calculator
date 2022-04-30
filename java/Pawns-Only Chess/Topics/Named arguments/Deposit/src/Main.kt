import kotlin.math.pow

const val CENT = 100
fun main() {
    val particulars = readln()
    val particularsValue = readln().toDouble()
    when (particulars) {
        "amount" -> compoundInterest(amount = particularsValue)
        "years" -> compoundInterest(years = particularsValue)
        "percent" -> compoundInterest(percent = particularsValue)
        else -> compoundInterest()
    }
}

fun compoundInterest(amount: Double = 1000.0, percent: Double = 5.0, years: Double = 10.0) {
    val finalAmount = amount * (1 + percent / CENT).pow(years)
    println(finalAmount.toInt())
}