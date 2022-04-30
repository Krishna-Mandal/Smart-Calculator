class Employee(val clothesSize: Int) {
    val uniform = Uniform()
    class Uniform {
        val uniformType = "suit"
        val uniformColor = "blue"
    }

    fun printUniformInfo() {
        println("The employee wears a ${uniform.uniformColor} ${uniform.uniformType} in size ${this.clothesSize}")
    }
}