
class Task(
    val name: String,
    var isCompleted: Boolean,
)
fun main() {
    val tasks = mutableListOf<Task>()
    while(true){
        println("Enter command (show/add/delete/done/filter/group/exit)")
        val command = readLine()?.trim()?.lowercase()
        when (command) {
            "show" -> showTasks(tasks,"all")
            "add" ->{
                println("Enter task name:")
                val taskName = readLine()?.trim()
                if (!taskName.isNullOrBlank()) {
                    addTask(tasks,taskName)
                }else{
                    println("Task name not null")
                }
            }
            "delete" ->{
                println("Enter task index:")
                val index = readLine()?.trim()?.toIntOrNull()
                if (index == null) {
                    println("Task not found")
                }else{
                    deleteTask(index,tasks)
                }
            }
            "done" ->{
                println("Enter task index:")
                val index = readLine()?.trim()?.toIntOrNull()
                if (index == null) {
                    println("Task not found")
                }else{
                    markTaskDone(tasks,index)
                }
            }
            "filter" ->{
                println("Enter filter (all/done/notdone):")
                val filterName = readLine()?.trim()?.lowercase()?: "all"
                if (filterName in listOf("all","done","notdone")) showTasks(tasks,filterName)
                else println("Invalid filter")
            }
            "group" -> groudTaskByStatus(tasks)
            "exit" ->{
                println("Goodbye!")
                break
            }
            else -> println("Unknown command")
        }
    }
}

fun addTask(tasks:MutableList<Task>,name:String){
    tasks.add(Task(name,false))
    println("Added ${name} ")
}
fun showTasks(tasks:List<Task>,filter:String){
    if (tasks.isEmpty()){
        println("No tasks")
        return
    }
    tasks.withIndex()
        .filter { taskWithIndex ->
            when(filter){
                "done" -> taskWithIndex.value.isCompleted
                "notdone" -> !taskWithIndex.value.isCompleted
                else -> true
            }
        }
        .forEach { (i, task) ->
            println("$i : ${task.name} | status: ${if (task.isCompleted) "done" else "not done"}")
        }
}
fun deleteTask(index: Int,tasks: MutableList<Task>){
    if (index in tasks.indices){
        val task = tasks[index]
        tasks.removeAt(index)
        println("Removed ${task.name} ")
    }else{
        println("Invalid index")
    }

}
fun markTaskDone(tasks:MutableList<Task>, index:Int){
    if (index in tasks.indices){
        tasks[index].isCompleted =true
        println("Task ${tasks[index].name} is done")
    }else{
        println("Invalid index")
    }
}
fun groudTaskByStatus(tasks:List<Task>){
    val grouped = tasks.groupBy { it.isCompleted }
    println("Task by grouped status")
    grouped.forEach { isCompleted, listTasks ->
        println("${if (isCompleted) "done" else "not done"} Tasks:")
        listTasks.forEach { println("- ${it.name}") }
    }
}
