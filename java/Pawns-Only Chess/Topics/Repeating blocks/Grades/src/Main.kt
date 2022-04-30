const val A_GRADE = 5
const val B_GRADE = 4
const val C_GRADE = 3
const val D_GRADE = 2
const val FAIL = 1

fun main() {
    val num = readLine()!!.toInt()
    var aGrade = 0
    var bGrade = 0
    var cGrade = 0
    var dGrade = 0
    var fail = 0

    repeat(num) {
        val currentVal = readLine()!!.toInt()
        if (currentVal == A_GRADE) {
            ++aGrade
        } else if (currentVal == B_GRADE) {
            ++bGrade
        } else if (currentVal == C_GRADE) {
            ++cGrade
        } else if (currentVal == D_GRADE) {
            ++dGrade
        } else {
            ++fail
        }
    }

    println("$dGrade $cGrade $bGrade $aGrade")
}