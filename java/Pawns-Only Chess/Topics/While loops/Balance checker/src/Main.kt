const val ZERO = 0
fun main() {
    val input = readln().toInt()
    val outputs = readln().split(" ").map { it.toInt() }
    val totalEx = outputs.sum()

    if (totalEx > input) {
        val totalb4Last = totalEx - outputs.last()
        val balance = input - totalb4Last
        println("Error, insufficient funds for the purchase. Your balance is $balance, but you need ${outputs.last()}.")
    } else {
        println("Thank you for choosing us to manage your account! Your balance is ${input - totalEx}.")
    }

}