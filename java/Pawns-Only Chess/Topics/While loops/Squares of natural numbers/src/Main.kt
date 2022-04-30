fun main() {
    val limit = readln().toInt()
    var init = 1
    while (init * init <= limit) {
        println(init * init)
        init++
    }
}