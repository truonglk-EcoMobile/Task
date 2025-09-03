fun main(){
    var name ="Truong" //có thể thay đổi
    val pi = 3.14 // không thể thay đổi
    println("Biến: $name, hằng số: $pi")

    // Kiểu dữ liệu cơ bản
    val soNguyen: Int = 42
    val soThucNho: Float = 3.14f // cần thêm f ở cuối
    val soThucLon: Double = 3.1415
    val kyTu: Char = 'T'
    val chuoi: String = "Hello Kotlin"
    val dungSai: Boolean = false
    val soDai: Long = 1234567890123456789L // cần thêm L ở cuối
    val soNho: Short = 123
    val soByte: Byte = 12

    // Toán tử
    var a = 10
    var b = 3
    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * b = ${a * b}")
    println("a / b = ${a / b}")
    println("a % b = ${a % b}")

    a += 5
    b -= 1
    println("a sau khi += 5: $a, b sau khi -= 1: $b")

    println("a > b: ${a > b}, a == b: ${a == b}, a != b: ${a != b}")
    println("Logic: ${(a > 0) && (b > 0)}, ${(a < 0) || (b > 0)}")

    // Ép kiểu
    val soText = "11"
    val soInt = soText.toInt()
    val soFloat = soInt.toFloat()
    println("soInt = $soInt soFloat = $soFloat")


}