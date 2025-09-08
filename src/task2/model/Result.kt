package task2.model

//seadled class
sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val message: String) : Result<T>()
    class Loading<T> : Result<T>()
}