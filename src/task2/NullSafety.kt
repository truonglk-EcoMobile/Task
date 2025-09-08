package task2
fun main() {
    val nonNullable: String = "Truong" //Không thể gán null
    val nullable: String? = null    // có thể gán null

    // Safe Call (?.)
    val text: String? = "Hello"
    println("Độ dài chuỗi: ${text?.length}") // Truy cập bình thường
    println("Độ dài chuỗi null: ${nullable?.length}") // Trả về null

    // Elvis Operator (?:)
    val length = nullable?.length ?: 0 // Nếu nullable là null không thì trả về 0
    println("Độ dài với Elvis: $length")

    // Not-null Assertion (!!)
    val notNullText: String = text!! //có thể gây NPE nếu text là null
    println("Chuỗi not-null Assertion: $notNullText")
}