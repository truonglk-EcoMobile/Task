package task3

import kotlinx.coroutines.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main(){
    var choice = -1
    while (choice != 0) {
        println("Nhập lựa chọn: " +
                "\n1. DEMO BLOCKING" +
                "\n2. DEMO COROUTINE" +
                "\n3. DEMO ASYNC")
        choice = readLine()!!.toInt()
        when(choice) {
            1 -> demoBlocking()
            2 ->demoCoroutine()
            3 -> demoAsync()
            else -> break
        }
    }

}

//Blocking: Thực hiện tuần tự câu lệnh sau đợi câu lệnh trước xong rồi nó mới thực thi
fun demoBlocking(){
    //Các hàm sẽ chạy tuần tự khi nào in từ 1 đến 1000 rồi mới in Word và cuối cùng là in Hello
    executeLongTask()
    sayWorld()
    //Block thread 2s
    Thread.sleep(2000)
    sayHello()
}

//Giả lập công việc gì đó mất nhiều thời gian
fun executeLongTask(){
    for (i in 1..2_000_000) {
        print("     ")
    }
}
fun sayHello() = println("Hello")
fun sayWorld() = println("World")

fun demoCoroutine(){
    runBlocking{ //Tạo 1 coroutine, mã theo sau không chạy tới khi coroutine của nó chạy xong
        launch{ //Tạo 1 coroutine, mã theo sau chạy được luôn
            delay(1000) //Tạm dừng 1s nhưng không block thread
            sayWorld()
        }
        sayHello()
    }
    println("Done")

}


fun demoAsync()=runBlocking{
    val time = measureTimeMillis {
        //Lazy: Chỉ chạy khi có lệnh start hoặc await
        val one = async(start = CoroutineStart.LAZY) { printOne() }
        val two = async(start = CoroutineStart.LAZY) { printTwo() }
        //Nếu như không gọi lệnh start thì nó sẽ chạy tuần tự lấy one trước rồi mới lấy two
        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}
suspend fun printOne(): Int {
    delay(1000L)
    return 4
}

suspend fun printTwo(): Int {
    delay(1000L)
    return 14
}