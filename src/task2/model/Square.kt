package task2.model

import task2.interfaces.Drawable
import task2.interfaces.Resize

// 1 class có thể implement nhiều interface nhưng chỉ 1 abstract class
class Square(private var size: Double) : Shape(), Drawable, Resize {
    override val name = "Square"
    override fun tinhDienTich(): Double = size * size
    override fun draw() {
        println("Drawing a square with size $size")
    }
    override fun resize(size: Double) {
        println("old size: ${this.size}, new size: $size")
        this.size = size
    }
}