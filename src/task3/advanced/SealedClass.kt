package task3.advanced


//Giới hạn các lớp con có thể kế thừa nó
sealed class Result(){
    class Success(val data: Int): Result()
    class Failure(val message: String): Result()
    class Loading(): Result()
}

fun updateUI(result: Result) {
    when (result) {
        is Result.Loading -> {
            println("Đang tải, vui lòng đợi")
        }
        is Result.Success -> {
            println("Thành công, dữ liệu là: ${result.data}")
        }
        is Result.Failure -> {
            println("Có lỗi xảy ra trong quá trình tải: ${result.message}")
        }
        //Không cần else do sealed class đã giới hạn các lớp con nên IDE có thể biết được hết các lớp con của nó
    }
}