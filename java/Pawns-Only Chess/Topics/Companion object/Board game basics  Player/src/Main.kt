const val HP = 100
data class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var newId = 0
        fun create(name: String): Player {
            return Player(newId++, name, HP)
        }
    }
}