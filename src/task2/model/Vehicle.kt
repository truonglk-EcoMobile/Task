package task2.model

open class Vehicle(
    val brand: String,
    val model: String,
    open val maxSpeed: Int
) {
    open fun start() {
        println("Vehicle $brand $model is starting")
    }

    open fun stop() {
        println("Vehicle $brand $model has stopped")
    }

    // Final fun - không thể override
    final fun getInfo() = "$brand $model (Max speed: ${maxSpeed}km/h)"
}
