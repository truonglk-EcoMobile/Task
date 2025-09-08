package task2.model

class Rectangle(
    private val dai: Double,
    private val rong: Double
) : Shape() {
    override val name = "Rectangle"
    override fun tinhDienTich(): Double = dai * rong
}