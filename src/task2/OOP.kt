package task2
import task2.model.BasicPerson
import task2.model.Car
import task2.model.Circle
import task2.model.Employee
import task2.model.Person
import task2.model.Priority
import task2.model.Product
import task2.model.Rectangle
import task2.model.Result
import task2.model.Square
import task2.model.User
import task2.`object`.DatabaseManager
import task2.`object`.MathUtils

fun handleResult(result: Result<out Any>) {
    when (result) {
        is Result.Success -> println("Success: ${result.data}")
        is Result.Error -> println("Error: ${result.message}")
        is Result.Loading -> println("Loading...")
    }
}

//nested & inner class
class OuterClass(private val outerProperty: String) {
    // Nested class - không truy cập được outer class
    class NestedClass {
        fun doSomething() = "Nested class method"
    }

    // Inner class - truy cập được outer class
    inner class InnerClass {
        fun accessOuter() = "Accessing outer: $outerProperty"
    }
}
fun main() {
    println("=== BASIC CLASS ===")
    val basicPerson = BasicPerson()
    basicPerson.name = "truong"
    basicPerson.age = 21
    basicPerson.introduce()

    println("=== PRIMARY CONSTRUCTOR ===")
    val person = Person("Luu", "Truong", 21)
    println(person.introduce())
    println("Full name: ${person.fullName}")
    person.displayName = " lktruong"
    println("Display name: ${person.displayName}")

    println("\n=== SECONDARY CONSTRUCTOR ===")
    val emp1 = Employee("Nguyen", "A", 25, "EMP001", 50000.0)
    val emp2 = Employee("Tran", "B", "EMP002")
    val emp3 = Employee("Hoang C", "EMP003")

    println("\n=== KẾ THỪA ===")
    val car = Car("Mercedes", "G63", 200, 4, "Gas")
    val electricCar = Car("Tesla", "Cyber chuck", 200, 4, "Electric")

    listOf(car, electricCar).forEach { vehicle ->
        println(vehicle.getInfo())
        vehicle.start()
        vehicle.stop()
        println()
    }
    car.open()

    println("\n=== ABSTRACT CLASS ===")
    val circle = Circle(5.0)
    val rectangle = Rectangle(4.0, 6.0)

    circle.printInfo()
    println()
    rectangle.printInfo()

    println("\n=== INTERFACE ===")
    val square = Square(3.0)
    square.printInfo()
    square.draw()
    square.resize(1.5)

    println("\n=== DATA CLASS ===")
    val product1 = Product("P001", "Laptop", 1500.0)
    val product2 = product1.copy(name = "Gaming Laptop", price = 2000.0)

    println("Product 1: $product1")
    println("Product 2: $product2")
    println("product 1 == product2 = ${product1 == product2}")

    val user1 = User("truong", "truong@gmail.com.com", 21)
    println("User1: $user1")
    try {
        val user2 = user1.copy(username = "")
    }catch (ex:Exception){
        println("loi khi khoi tao user2: $ex")
    }
    try {
        val user3 = user1.copy(email = "abcgmail.com")
    }catch (ex:Exception){
        println("loi khi khoi tao user3: $ex")
    }
    try {
        val user4 = user1.copy(age = -2)
    }catch (ex:Exception){
        println("loi khi khoi tao user4: $ex")
    }

    println("\n=== SEALED CLASS ===")
    val results = listOf(
        Result.Success(user1),
        Result.Error<String>("Network error"),
        Result.Loading<String>()
    )
    results.forEach { handleResult(it) }

    println("\n=== ENUM CLASS ===")
    val task1Priority = Priority.HIGH
    val task2Priority = Priority.MEDIUM
    println("Task 1: ${task1Priority.displayName}")
    println("Task 2: ${task2Priority.displayName}")
    println("Is task 1 higher priority than task 2?  ${task1Priority.isHigherThan(task2Priority)}")

    println("\n=== SINGLETON OBJECT ===")
    DatabaseManager.connect()
    println("Connected: ${DatabaseManager.isConnected()}")
    DatabaseManager.connect() // Already connected
    DatabaseManager.disconnect()

    println("\n=== COMPANION OBJECT ===")
    println("PI precision: ${MathUtils.PI_PRECISION}")
    println("5 + 3 = ${MathUtils.add(5, 3)}")
    val basicCalc = MathUtils.createCalculator("basic")
    val sciCalc = MathUtils.createCalculator("scientific")


    println("\n=== NESTED & INNER CLASSES ===")
    val nested = OuterClass.NestedClass()
    println("Nested: ${nested.doSomething()}")

    val outer = OuterClass("Outer data")
    val inner = outer.InnerClass()
    println("Inner: ${inner.accessOuter()}")

}