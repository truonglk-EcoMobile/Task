package task1

fun main(){
    demoVariable()
    demoDataType()
    demoOperator()
    demoConver()
}

// Biến và hằng số
fun demoVariable(){
    //mutable có thể thay đổi
    var name ="Truong"
    name = "LK Truong"
    println("mutable: $name")

    //imutable không thể thay đổi
    val pi = 3.14
    //pi = 10.0 //lỗi
    println("imutable: $pi")
}

//Kiểu dữ liệu cơ bản
fun demoDataType(){
    val soInt: Int = 42
    val soShort: Short = 123
    val soByte: Byte = 12
    val soFloat: Float = 3.14f // cần thêm f ở cuối
    val soDouble: Double = 3.1415
    val soLong: Long = 1234567890123456789L // cần thêm L ở cuối
    val kyTu: Char = 'T'
    val chuoi: String = "Hello"
    val dungSai: Boolean = false

    println("số Int: $soInt")
    println("số Short: $soShort")
    println("số Byte: $soByte")
    println("số Float: $soFloat")
    println("số Double: $soDouble")
    println("số Long: $soLong")
    println("ký tự: $kyTu")
    println("Chuỗi: $chuoi")
    println("Đúng sai: $dungSai")
}

//Toán tử
fun demoOperator(){
    //+ - * / %
    var a =20
    var b =4
    println("a + b = ${a.plus(b)}")
    println("a - b = ${a.minus(b)}")
    println("a * b = ${a.times(b)}")
    println("a / b = ${a.div(b)}")
    println("a % b = ${a.rem(b)}")

    //+=, -=, *=, ==, !=, >, <
    a+=3
    println("a +=3 = ${a}")
    a-=1
    println("a -=3 = ${a}")
    a/=2
    println("a /=2 = ${a}")
    a*=2
    println("a *=2 = ${a}")
    println("a>b: ${a>b}")
    println("a<b: ${a<b}")
    println("a!=b: ${a!=b}")
    println("a==b: ${a==b}")

    //&& ||
    var c = 2
    if (a>a && a>c){
        println("a = $a là lớn nhất")
    }
    if(a<b||a>c){
        println("a = $a không phải là lớn nhất")
    }
}

//Ép kiểu
fun demoConver(){
    val soText = "11.12"
    val soFloat = soText.toFloat()
    val soInt = soFloat.toInt()
    println("soInt = $soInt soFloat = $soFloat")
}