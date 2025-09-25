package task3.advanced

import kotlin.reflect.full.createInstance

var x: Int = 1

open class Person(val name: String="no name")
{
    open fun info(){
        println(name)
    }
}
class Employee(name: String = "No Name", var age: Int=0, var address: String="No address"): Person(name){
    override fun info() {
        super.info()
        println("$name, $age, $address")
    }

    override fun toString(): String {
        return "$name, $age, $address"
    }
}


fun main(){
    println("========= CLASS ========")
    demoReferencesClass()
    println("========= FUNCTION ========")
    demoReferencesFunction()
    println("========= PROPERTY ========")
    demoReferencesProperty()

}

fun demoReferencesClass() {
    //Tạo tham chiếu tới class Employee
    val employee = Employee::class
    println("Qualified name: ${employee.qualifiedName}")
    println("Is class: ${employee.isData}")
    println("Is companion object: ${employee.isCompanion}")
    println("Is abstract class: ${employee.isAbstract}")
    println("Is final class: ${employee.isFinal}")
    println("Is sealed class: ${employee.isSealed}")
    println("Constructor: ${employee.constructors}")

    //Khởi tạo 1 đối tượng của class đó 
    val e = employee.createInstance()
    println(e)
}

fun isOdd(n: Int): Boolean = n % 2 != 0

fun isOdd(s: String): Boolean = s.length % 2 != 0

fun String?.isValidName():Boolean{
    if(this.isNullOrEmpty()){
        return false
    }else{
        val regex = Regex("^[A-Z][a-zA-Z ]*$")
        return regex.matches(this)
    }
}

fun demoReferencesFunction() {
    val listNumbers = listOf<Int>(1,2,3,4,5)
    val listStrings = listOf<String>("Luu","Kien", "Truong")

    //Do ở trên listNumbers là list kiểu Int nên predicate của filter có kiểu dữ liệu là (Int) -> Blolean
    println(listNumbers.filter(::isOdd)) //Nên ở dây tự động nhận isOdd(n: Int)
    println(listStrings.filter(::isOdd)) //Nhận isOdd(s: String)

    val listNames = listOf("Luu Kien Truong"," 21dfe@")
    println("Ten dung dinh dang: ${listNames.filter(String::isValidName)}")
}


fun demoReferencesProperty() {
    println("x = ${::x}")
    println("name: ${::x.name}")
    println("Is final: ${isOdd(4)}")
    println("Is abstract: ${::x.isAbstract}")
    println("Is lateinit: ${::x.isLateinit}")
    println("Is open: ${::x.isOpen}")
    //Chỉ dùng được khi khai báo bàng var
    ::x.set(2)
}