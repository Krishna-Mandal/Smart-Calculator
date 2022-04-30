import java.math.BigInteger

fun main() {
    val in1 = readln().toBigInteger()
    val in2 = readln().toBigInteger()
    println((in1 + in2 + (in1 - in2).abs()) / BigInteger.TWO)
}