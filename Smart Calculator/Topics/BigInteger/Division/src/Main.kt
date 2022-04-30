fun main() {
    val in1 = readln().toBigInteger()
    val in2 = readln().toBigInteger()

    val (q, r) = in1.divideAndRemainder(in2)

    println("$in1 = $in2 * $q + $r")

}