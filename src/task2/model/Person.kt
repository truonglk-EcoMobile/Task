package task2.model


//primary constructor
open class Person(
    val firstName: String,
    var lastName: String,
    var age: Int = 0
) {
    // Init block - chạy khi object được khởi tạo
    init {
        println("Person created: $firstName $lastName")
        require(age >= 0) { "Age phai >0" }
    }
    val fullName: String
        get() = "$firstName $lastName"

    // Custom getter/setter
    var displayName: String = fullName
        get() = field.uppercase()
        set(value) {
            field = value.trim()
        }

    fun introduce() = "Hello $fullName $age tuoi"
}