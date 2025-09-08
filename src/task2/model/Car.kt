package task2.model

//kế thừa
class Car(
    brand: String,
    model: String,
    maxSpeed: Int,
    val numDoors: Int = 4,
    val fuelType: String = "Gas"
) : Vehicle(brand, model, maxSpeed) {
    //overide thuộc tính
    override val maxSpeed: Int = maxSpeed
        get() = if (fuelType == "Electric") field + 20 else field

    override fun start() {
        println("Car $brand $model is starting")
        super.start() // Gọi phương thc của parent
    }

    fun open() {
        println("opened")
    }
}
