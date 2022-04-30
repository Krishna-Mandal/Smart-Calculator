enum class CountryCurrency(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar"),
    NULL("");

    companion object {
        fun haveSameCurrency(country1: String, country2: String): Boolean {
            return CountryCurrency.nameOf(country1).currency == CountryCurrency.nameOf(country2).currency &&
                CountryCurrency.nameOf(country1) != NULL && CountryCurrency.nameOf(country2) != NULL
        }

        fun nameOf(country1: String): CountryCurrency {
            val found = values().filter { it.name == country1 }
            return if (!found.isNullOrEmpty()) found.first() else NULL
        }
    }
}
fun main() {
    val (first, second) = readln().split(" ")
    println(CountryCurrency.haveSameCurrency(first, second))
}