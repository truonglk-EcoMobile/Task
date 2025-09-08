package task2.`object`

//SINGLETON OBJECT
object DatabaseManager {
    private var isConnected = false

    fun connect() {
        if (!isConnected) {
            println("Connecting to database...")
            isConnected = true
        } else {
            println("Already connected")
        }
    }

    fun disconnect() {
        if (isConnected) {
            println("Disconnecting from database...")
            isConnected = false
        }
    }

    fun isConnected() = isConnected
}
