package task2
fun main() {
    println("Tổng: ${sum(5, 3)}")
    println("Bình phương: ${square(4)}")

    //named argument
    greet(lastName = "truong", firstName = "luu")
    //default parameter
    greet(firstName = "luu")

    val name = "Truong"
    println(name.addHello())
}

// Hàm thông thường
fun sum(a: Int, b: Int): Int {
    return a + b
}

// Hàm một dòng
fun square(number: Int): Int = number * number

// Hàm với default parameter
fun greet(firstName: String, lastName: String = "A") {
    println("Hell $firstName, $lastName")
}

// Extension function
fun String.addHello(): String {
    return "Hello $this"
}