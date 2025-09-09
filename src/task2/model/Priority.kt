package task2.model

enum class Priority(val value: Int, val displayName: String) {
    LOW(1, "Low Priority") {
        override fun getDescription(): String = "Công việc ít quan trọng nhất"
    },
    MEDIUM(2, "Medium Priority"){
        override fun getDescription(): String = "Công việc có độ quan trọng vừa phải nên được làm sớm"

    },
    HIGH(3, "High Priority") {
        override fun getDescription(): String = "Công việc có độ quan trọng cao phải được chú ý ngay"
    },
    VERY_HIGH(4, "Very high Priority") {
        override fun getDescription(): String = "Công việc quan trọng nhất cần được xử lý khẩn cấp"
    };

    fun isHigherThan(other: Priority): Boolean {
        return this.value > other.value
    }
    abstract fun getDescription(): String
}