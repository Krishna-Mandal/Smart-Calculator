data class Vehicle(var name: String) {

    inner class Body(var color: String) {

        fun printColor() {
            println("The $name vehicle has a ${this.color} body.")
        }

    }
}