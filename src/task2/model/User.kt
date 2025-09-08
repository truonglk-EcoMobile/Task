package task2.model

// Data class với validation
data class User(
    val username: String,
    val email: String,
    val age: Int
) {
    init {
        //Lỗi IllegalArgumentException nếu như không thỏa mãn điều kiện khi khởi tạo
        require(username.isNotBlank()) { "Username cannot be blank" }
        require(email.contains("@")) { "Invalid email format" }
        require(age > 0) { "Age must be positive" }
    }
}