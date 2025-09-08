package task2.model

enum class Priority(val value: Int, val displayName: String) {
    LOW(1, "Low Priority"),
    MEDIUM(2, "Medium Priority"),
    HIGH(3, "High Priority"),
    VERY_HIGH(4, "Very high Priority");

    fun isHigherThan(other: Priority): Boolean {
        return this.value > other.value
    }
}