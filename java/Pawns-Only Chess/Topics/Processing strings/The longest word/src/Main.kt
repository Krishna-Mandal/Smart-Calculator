fun main() {
    println(readln().split(" ").groupBy { it.length }.maxByOrNull { it.key }!!.value.first())
}