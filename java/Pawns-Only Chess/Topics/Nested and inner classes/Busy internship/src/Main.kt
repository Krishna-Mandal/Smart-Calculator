const val BASE_WORKLOAD = 20
const val BASE_PAY = 50
const val EXTRA_PAY = 50
data class Intern(val weeklyWorkload: Int) {
    val baseWorkload = BASE_WORKLOAD

    class Salary {
        val basePay = BASE_PAY
        val extraHoursPay = EXTRA_PAY
    }

    private val salary = Salary()
    val weeklySalary = salary.basePay + (weeklyWorkload - baseWorkload) * salary.extraHoursPay
}