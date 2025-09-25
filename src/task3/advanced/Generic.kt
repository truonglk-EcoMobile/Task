package task3.advanced

//Tham số kiểu: Nghĩa là khi khởi tạo ta phải truyền kiểu giữ liệu cho nó

//Chấp nhận mọi kiểu dữ liệu
class Data<T>(value:T) {}

//Giới hạn kiểu dữ liệu
class onlyNumberData<T: Number>(val value:T) {}

//in: Chỉ nhận vào, không trả ra
interface inData<in T>{
    fun printData(data:T){}

    //Lỗi
    //fun getData():T
}

class StringInData(): inData<String> {
    override fun printData(data: String) {
        println(data)
    }
}

//out:Chỉ trả ra, không nhận vào
interface outData<out T>{
    fun returnData():T

    //Lỗi
    //fun printData(data:T)
}

class StringOutData(): outData<String> {
    override fun returnData(): String = "Out Data"
}
fun main() {
    val intData = Data<Int>(1)
    val stringData = Data<String>("Tham số kiểu String")
    val daysData = Data<Days>(Days.THURSDAY)

    val intData2 = onlyNumberData<Int>(2)
    val doubleData2 = onlyNumberData<Double>(0.1)
//    val stringData2 = onlyNumberData<String>("Chỉ nhận số") bị báo lỗi do giới hạn chỉ nhận Numbers

    val stringIn = StringInData()
    val stringOut = StringOutData()
    stringIn.printData("In data")
    println(stringOut.returnData())

}
