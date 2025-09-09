package task2

import task2.model.Person

fun main(){
    println("\n=== LET FUNCTION ===")
    demoLet()
    println("\n=== RUN FUNCTION ===")
    demoRun()
    println("\n=== ALSO FUNCTION ===")
    demoAlso()
    println("\n=== APPLY FUNCTION ===")
    demoApply()
    println("\n=== WITH FUNCTION ===")
    demoWith()
}

//let function
fun demoLet(){
    val fullName = "Luu Kien Truong"
    //dùng với ?. để chỉ chạy nếu fullName !=null
    val lengthLastName = fullName?.let{ fullName -> //nếu không đặt tên thì gọi bằng it
        println("Last name: ${fullName.split(" ").last()}")
        fullName.split(" ").last().length
    }
    println("Độ dài của last name là: ${lengthLastName}")
}

//run function
fun demoRun(){
    val truong = Person("luu","truong",21)
    val helloPerson = truong.run{ //dùng this hoặc gọi trực tiếp thuộc tính của class cũng được
        "Hello $firstName $lastName đã đạt ${this.age} tuổi"
    }
    println(helloPerson)
}

//also function
fun demoAlso(){
    val truong = Person("luu","truong",21).also{ //dùng it
        println("Đã tạo person có tên ${it.lastName} thành công")
    }
}

//apply function
fun demoApply(){
    val person = Person("luu","luu",21).apply{// dùng this hoặc gọi trực tiếp thuộc tính của class cũng được
        this.lastName = "truong"
        age = 22
    }
    println("person sau khi dùng apply:${person.firstName} ${person.lastName}, ${person.age}")
}

//with function
fun demoWith(){
    val nguoi = Person("luu","truong",21)
    val description = with(nguoi){ // dùng this
        "Họ và tên: ${this.firstName} ${this.lastName}, năm nay đã $age tuổi"
    }
    println(description)
}
