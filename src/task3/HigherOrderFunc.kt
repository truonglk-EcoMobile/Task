package task3

fun main(){
    demoHigherOrderFunc()
    demoLambdaFunc()
}

fun caculateSum(a:Int,b:Int):Int = a.plus(b)

fun caculateMinus(a:Int,b:Int):Int = a.minus(b)

fun caculateTimes(a:Int,b:Int):Int = a.times(b)

fun caculateDivision(a:Int,b:Int):Int = a.div(b)

//Hàm nhận một hàm khác làm tham số:
//Do (Int, Int) -> Int cũng là một kiểu dữ liệu nên ta có thể truyền vào hàm
//Hàm tính liên tiếp các số trong dãy từ start đến end theo công thức truyền vào
fun caculateWithFunc(start:Int,end: Int, operation:(Int,Int)-> Int):Int{
    if (start>end){
        return 0
    }
    var result =start
    try {
        for(i in start+1..end){
            result = operation(result,i)
        }
    }catch(e:Exception){
        println("Lỗi: ${e.message}")
    }
    return result
}

//Hàm trả về một hàm khác
fun selectCaculate(code: FuncCaculateCode):(Int, Int) -> Int{
    return when (code){
        FuncCaculateCode.SUM -> ::caculateSum
        FuncCaculateCode.MINUS -> ::caculateMinus
        FuncCaculateCode.TIMES -> ::caculateTimes
        FuncCaculateCode.DIVISION -> ::caculateDivision
    }
}

fun demoHigherOrderFunc(){
    //Gán 1 hàm cho biến, biến này sẽ có kiểu dữ liệu là (Int, Int) -> Int
    var caculate:(Int, Int) -> Int = ::caculateSum
    println("sum: ${caculate(3, 2)}")

    //Do caculateSum và caculateTime có cùng kiểu dữ liệu nên ta có thể gán qua lại cho biến caculate
    caculate= ::caculateTimes
    println("times: ${caculate(3,2)}")

    //Tính toán với hàm sum
    caculate = ::caculateSum
    println("Tính với sum: ${caculateWithFunc(1,4,caculate)}")

    //Tính toán với hàm times
    caculate = ::caculateTimes
    println("Tính với times: ${caculateWithFunc(1,4,caculate)}")

    //Tính toán với hàm minus do một hàm khác trả về hàm này
    println("Tính với division: ${caculateWithFunc(1,4,selectCaculate(FuncCaculateCode.MINUS))}")
}

//Lambda
fun demoLambdaFunc(){
    //Lambda là hàm literial không được khai báo bằng từ khóa fun
    //và được truyền dưới dạng biểu thức

    //Truyền bên phải phép gán
    val applyCaculate: (Int, Int)-> Int= {a,b -> a.plus(b)}
    println("Lambda truyền bên phải phép gán: ${applyCaculate(3, 2)}")
    //Truyền vào lệnh gọi hàm
    println("Lambda truyền vào lệnh gọi hàm: ${caculateWithFunc(2,5,{ a,b -> a.times(b)})}")

    //Trailling lambda: Nếu lambda là tham số cuối ta có thể bỏ nó ra ngoài ngoặc đơn
    println("Trailling lambda:${caculateWithFunc(2,5){a,b ->
        (a.times(b)).plus(2)
    }}")

}

// Inline function: Hàm được đánh dấu inline sẽ thay thế lời gọi hàm bằng code của lambda tại nơi gọi
inline fun calculateWithInline(start: Int, end: Int, operation: (Int, Int) -> Int): Int {
    if (start > end) {
        return 0
    }
    var result = start
    try {
        for (i in start + 1..end) {
            result = operation(result, i)
        }
    } catch (e: Exception) {
        println("Lỗi inline: ${e.message}")
    }
    return result
}

// Demo sử dụng inline function
fun demoInlineFunc() {
    println("Demo Inline Function:")
    println("Inline với sum: ${calculateWithInline(1, 4) { a, b -> a + b }}")
    println("Inline với times và plus: ${calculateWithInline(1, 4) { a, b -> a * b + 2 }}")
}