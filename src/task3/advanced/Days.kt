package task3.advanced

//Enum class có thể có thuộc tính mặc định hoặc không mặc định thì mỗi hằng số phải định nghĩa
enum class Days(val isWeekend:Boolean = false) {
    MONDAY {
        override fun nameVietNamese(): String {
            return "Thứ hai"
        }
    },
    TUESDAY {
        override fun nameVietNamese(): String {
            return "Thứ ba"
        }
    },
    WEDNESDAY {
        override fun nameVietNamese(): String {
            return "Thứ tư"
        }
    },
    THURSDAY {
        override fun nameVietNamese(): String {
            return "Thứ năm"
        }
    },
    FRIDAY {
        override fun nameVietNamese(): String {
            return "Thứ sáu"
        }
    },
    SATURDAY(true) {
        override fun nameVietNamese(): String {
            return "Thứ bảy"
        }
    },
    SUNDAY(true) {
        override fun nameVietNamese(): String {
            return "Chủ nhật"
        }
    };

    //Enum cũng có thể có abstrace function và các hằng số phải ghi đè lại
    abstract fun nameVietNamese():String
}

fun main(){
    //val a = enum() không thể khởi tạo một đối tượng là enum class

    //enum.entries: lấy danh sách các hằng số
    for (i in Days.entries){
        //i.ordinal: Lấy vị trí của hằng số (bắt đầu từ 0)
        println("${i.ordinal} $i in Viet Nam mean ${i.nameVietNamese()} and $i is weekend: ${i.isWeekend}")
    }
}