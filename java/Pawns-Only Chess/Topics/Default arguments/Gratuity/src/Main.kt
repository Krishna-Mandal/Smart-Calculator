const val CENT = 100
fun tip(bill: Int, percentage: Int = 10): Int {
    return bill * percentage / CENT
}