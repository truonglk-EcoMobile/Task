package task2.interfaces

interface Drawable {
    fun draw()
    // Interface có thể có default func
    fun loading() {
        println("Loading...")
    }
}