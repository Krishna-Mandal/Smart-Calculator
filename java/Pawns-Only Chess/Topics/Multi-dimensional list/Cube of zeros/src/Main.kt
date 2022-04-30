const val SIZE_3 = 3
const val INIT_0 = 0
fun main() {
    val list3d = MutableList(SIZE_3) {
        MutableList(SIZE_3) {
            MutableList(SIZE_3) { INIT_0 }
        }
    }

    println(list3d)
}