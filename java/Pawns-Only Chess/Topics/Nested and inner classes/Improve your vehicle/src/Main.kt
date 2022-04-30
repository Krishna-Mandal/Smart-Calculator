data class Vehicle(var name: String) {

    inner class Engine(var horsePower: Int) {

        fun start() {
            println("RRRrrrrrrr....")
        }

        fun printHorsePower() {
            println("The ${this@Vehicle.name} vehicle has ${this.horsePower} horsepower.")
        }
    }
}