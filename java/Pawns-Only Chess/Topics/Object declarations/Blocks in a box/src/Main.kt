const val LENGTH = 6
const val WIDTH = 4
data class Block(val color: String) {
    object BlockProperties {
        var length = LENGTH
        var width = WIDTH

        fun blocksInBox(length: Int, width: Int): Int {
            return length / this.length * (width / this.width)
        }
    }
}