package task2.model
// abstract class
abstract class Shape {
    abstract val name: String
    abstract fun tinhDienTich(): Double
    fun printInfo() {
        println("Shape: $name")
        println("Dien tich: %.2f".format(tinhDienTich()))
    }
}
