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
                "\n3. DEMO ASYNC" +
                "\n4. DEMO WITHCONTEXT AND DISPATHCHER" +
                "\n5. DEMO JOB & JOIN" +
                "\n6. DEMO CANCEL COROUTINE SUCCESS" +
                "\n7. DEMO CANCEL COROUTINE FAILURE" +
                "\n8. DEMO WITH TIME OUT" +
                "\n9. DEMO COROUTINE SCOPE" +
                "\n10. DEMO EXCEPTION IN LAUNCH" +
                "\n11. DEMO EXCEPTION IN ASYNC" +
                "\n12. DEMO COROUTINE EXCEPTION HANDLER")
        choice = readLine()!!.toInt()
        when(choice) {
            1 -> demoBlocking()
            2 -> demoCoroutine()
            3 -> demoAsync()
            4 -> demoWithContextAndDispatcher()
            5 -> demoJobAndJoin()
            6 -> demoCancelCoroutineSuccess()
            7 -> demoCancelCoroutineFail()
            8 -> demoWithTimeOut()
            9 -> demoCoroutineScope()
            10 -> demoExceptionWithLaunch()
            11 -> demoExceptionWithAsync()
            12 -> demoCoroutineExceptionHandler()
            else -> break
        }
    }

}

//Blocking: Thực hiện tuần tự câu lệnh sau đợi câu lệnh trước xong rồi nó mới thực thi
fun demoBlocking(){
    //Các hàm sẽ chạy tuần tự khi nào xong long task rồi mới in Word và cuối cùng là in Hello
    executeLongTask()
    sayWorld()
    //Block thread 2s
    Thread.sleep(2000)
    sayHello()
}

//Giả lập công việc gì đó mất nhiều thời gian
fun executeLongTask(){
    for (i in 1..2_000_000) {
        print(" ")
    }
}
fun sayHello() = println("Hello")
fun sayWorld() = println("World")

fun demoCoroutine(){
    runBlocking{ //Tạo 1 coroutine, mã theo sau không chạy tới khi coroutine của nó chạy xong
        launch{ //Tạo 1 coroutine, mã theo sau chạy được luôn, nếu không set context thì mặc định là Default
            delay(1000) //Tạm dừng 1s nhưng không block thread
            sayWorld()
        }
        sayHello()
    }
    println("Done")

}

//withContext: chỉ định khối code trong nó chạy trên thread nào
fun demoWithContextAndDispatcher(){
    runBlocking(){//Mặc định runBlocking là Dispatchers.Main: Các tác vụ liên quan tới cập nhật UI
        println("Current Thread: ${Thread.currentThread().name}")
        withContext(Dispatchers.Default){//Các tác vụ tính toán nặng
            println("Thread in withContext (default): ${Thread.currentThread().name}")
        }
        withContext(Dispatchers.IO){//Các tác vụ liên quan tới IN/OUT như đọc ghi file, network
            println("Thread in withContext (IO): ${Thread.currentThread().name}")
        }
        withContext(Dispatchers.Unconfined){ //Không bij giới hạn thread, ban đầu ở thread của coroutine chứa nó sau khi bị tạm dừng và tiếp tục lại thì ở thread khác
            println("Unconfined Thread before delay: ${Thread.currentThread().name}")
            delay(1000L)
            println("Unconfined Thread after delay: ${Thread.currentThread().name}")
        }
    }
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

//Job:Quản lý lifecycle của coroutine
fun demoJobAndJoin() = runBlocking {
    val job: Job = launch {
        delay(1000L)
        sayHello()
    }
    //Đợi tới khi job xong mới chạy tiếp
    job.join()
    sayWorld()
}

fun demoCancelCoroutineSuccess(){
    runBlocking {
        var i =0
        val job: Job = launch {
            while (i<=10){
                delay(1000L)
                println("i: $i")
                i++
            }
        }
        if (i>=5){
            job.cancel()
        }
        println("Done")
    }
}

//Sau 4.5s thì vẫn tiếp tục in i ra đến hết vòng while mặc dù mất tận 10s mới xong mà sau 4.5s là gọi lệnh cancel
//Lý do là vì cancel chỉ set lại thuộc tính isActive thành false nên các tiến trình vẫn chạy tiếp
//Lý do hàm bên trên dừng được là do delay() ngoài tạm dừng thì bản thân nó cũng có chức năng kiểm tra coroutine còn sống không
//nếu isActive == false thì sẽ dừng coroutine lại ngay.
//Không chỉ riêng delay mà tất cả hàm suspend của thư viện kotlin coroutine đều có chức năng này
fun demoCancelCoroutineFail(){
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job: Job = launch {
            var nextPrintTime = startTime
            var i = 0
            while (i <=10) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("i: $i")
                    i++
                    nextPrintTime += 1000L
                }
            }
        }
        delay(4500L)
        job.cancel()
        println("Done")
    }
}

//Hủy coroutine khi hết thời gian nếu chạy xong trước khi hủy thì không sao
//Khi hết thời gian nếu chưa chạy xong sẽ throw ra một exception là TimeoutCancellationException
//Có thể dùng withTimeOutOrNull để trả về null thay vì throw exception
fun demoWithTimeOut(){
    runBlocking {
        try {
            withTimeout(3000L) {
                for (i in 1..10) {
                    delay(1000L)
                    println("i: $i")
                }
            }
        }catch (e: TimeoutCancellationException){
            println("timeout exception")
        }
    }
}

//Coroutine cha luôn đợi coroutine con chạy hết nên "Im parent" mới được in ra cuối
fun demoCoroutineScope(){
    runBlocking {
        launch(){
            delay(1000L)
            println("Im children1")
        }
        coroutineScope{
            launch {
                delay(2000L)
                println("Im children2")
            }
            delay(500L)
            println("Im children4")
        }
        println("Im parent")
    }
}

//Khi gặp lỗi sẽ throw luôn
@OptIn(DelicateCoroutinesApi::class)
fun demoExceptionWithLaunch(){
    runBlocking {
        val launch = GlobalScope.launch {
            println("Exception in launch")
            throw ArithmeticException()
        }
    }
}

//Khi gặp lỗi sẽ đóng gói vào Deferred ở đây là exception và khi biến này gọi await thi mới bị lỗi
@OptIn(DelicateCoroutinesApi::class)
fun demoExceptionWithAsync(){
    runBlocking {
        val exception = GlobalScope.async {
            println("Exception in async")
            throw ArithmeticException()
        }
        exception.join()
        println("Im still alive after exception") //Vẫn in ra chưa bị lỗi
        exception.await() //bị lỗi
        println("Im never print")
    }
}

//CoroutineExceptionHandler
fun demoCoroutineExceptionHandler(){
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Exception: $exception")
    }

    val job = GlobalScope.launch(handler) {
        throw AssertionError()
    }

    val deferred = GlobalScope.async(handler) {
        throw ArithmeticException()
    }

}

