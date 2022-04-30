@SuppressWarnings("All")
// complete this function, add default values
fun carPrice(old: Int = 5, kilometers: Int = 100_000, maximumSpeed: Int = 120, automatic: Boolean = false) {
    val yearDepreciation = old * 2000 * -1
    val depreciationByKM = (kilometers / 10_000.0).toInt() * 200 * -1
    val automaticAppreciation = if (automatic) 1_500 else 0
    val speedPriceChange = (maximumSpeed - 120) * 100

    println(20_000 + yearDepreciation + depreciationByKM + automaticAppreciation + speedPriceChange)
}