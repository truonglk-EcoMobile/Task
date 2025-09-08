package task2.model

data class Product(
    val id: String,
    val name: String,
    val price: Double,
) {
    // Data class tự động tạo: equals(), hashCode(), toString(), copy()
}