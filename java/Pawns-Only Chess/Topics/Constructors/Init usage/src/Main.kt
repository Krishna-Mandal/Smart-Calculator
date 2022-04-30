const val MAX = 127
const val MIN = -128

fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

data class ByteTimer(var time: Int) {
    init {
        when {
            time > MAX -> time = MAX
            time < MIN -> time = MIN
            else -> time
        }
    }
}