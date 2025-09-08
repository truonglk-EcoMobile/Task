package task2.model

class Circle(private val radius: Double) : Shape() {
    override val name = "Circle"
    override fun tinhDienTich(): Double = 3.14 * radius * radius
}