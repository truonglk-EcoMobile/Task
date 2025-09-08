package task2.`object`

//COMPANION OBJECT
class MathUtils {
    companion object {
        const val PI_PRECISION = 3.1415

        fun add(a: Int, b: Int) = a + b
        fun createCalculator(type: String) {
            return when (type.lowercase()) {
                "basic" -> {
                    println("basis calculator")
                }
                "scientific" -> {
                    println("scientific calculator")
                }
                else -> {
                    println("basis calculator")
                }
            }
        }
    }
}
