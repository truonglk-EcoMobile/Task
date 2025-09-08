package task2.model

class Employee(
    firstName: String,
    lastName: String,
    age: Int,
    val id: String,
    var salary: Double
) : Person(firstName, lastName, age) {
    // Secondary constructor 1
    constructor(
        firstName: String,
        lastName: String,
        employeeId: String
    ) : this(firstName, lastName, 0, employeeId, 0.0) {
        println("Employee created secondary constructor 1")
    }
    // Secondary constructor 2
    constructor(
        fullName: String,
        employeeId: String
    ) : this(
        fullName.split(" ").first(),
        fullName.split(" ").get(1)?:"",
        employeeId
    ){
        println("Employee created secondary constructor 2")
    }

}