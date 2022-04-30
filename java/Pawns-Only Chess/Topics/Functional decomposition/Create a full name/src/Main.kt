// use this code as a source of inspiration for your function
fun getFullNames() {
    val firstName1 = readln()
    val lastName1 = readln()
    println(createFullName(firstName1, lastName1))

    val firstName2 = readln()
    val lastName2 = readln()
    println(createFullName(firstName2, lastName2))

    val firstName3 = readln()
    val lastName3 = readln()
    println(createFullName(firstName3, lastName3))
}

// implement your function here
fun createFullName(first: String, last: String): String {
    return "$first $last"
}