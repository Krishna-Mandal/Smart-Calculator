fun main() {
    val count = readLine()

    println("${count!!.length} repetitions of the word $count: ${count.repeat(count.length)}")
}

