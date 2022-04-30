const val PASS = "pass"
const val PASSWORD = "password"
const val NOT_FOUND = "not found"
fun main() {
    val input = readln().substringAfter("?").split("&").associate {
        it.split("=").first() to
                it.split("=").last().ifBlank {
                    NOT_FOUND
                }
    }.toMutableMap()

    if (input.keys.contains(PASS)) {
        val temp: String
        val pass = input[PASS]
        temp = if (!pass.isNullOrBlank()) {
            pass
        } else {
            NOT_FOUND
        }
        input[PASSWORD] = temp
    }

    input.forEach {
        println("${it.key} : ${it.value}")
    }
}