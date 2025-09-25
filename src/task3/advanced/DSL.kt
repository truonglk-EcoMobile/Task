package task3.advanced

fun main() {
    val myTodo = todoList {
        task("Học Kotlin")
        task("Làm bài tập Task3") {
            done = true
        }
        task("Xem phim") {
            priority = 2
        }
    }

    myTodo.show()
}

// Lớp TodoList là container chứa nhiều Task
class TodoList {
    private val tasks = mutableListOf<Task>()

    // Hàm task() được dùng trong DSL
    // name: tên công việc
    // block: block để config Task (có thể bỏ qua)
    fun task(name: String, block: (Task.() -> Unit)? = null) {
        val t = Task(name)    // tạo task mới
        block?.let { t.it() }  // nếu có block config thì chạy trên task
        tasks.add(t)
    }

    fun show() {
        println("===== TODO LIST =====")
        tasks.forEach { println(it) }
    }
}

class Task(private val name: String) {
    var done: Boolean = false
    var priority: Int = 1

    override fun toString(): String {
        val status = if (done) "V" else "X"
        return "$status [$priority] $name"
    }
}

// Nhận vào 1 lambda với receiver là TodoList
fun todoList(block: TodoList.() -> Unit): TodoList {
    val t = TodoList() // tạo TodoList
    t.block()          // thực thi block DSL trên nó
    return t           // trả về kết quả
}
