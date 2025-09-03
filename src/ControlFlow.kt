fun main(){
    val a = 8
    val b = 10
    // Điều kiện
    if (a > b) {
        println("a lớn hơn b")
    }else if (a == b) {
        println("a bằng b")
    }else{
        println("a nhỏ hơn b")
    }

    // When
    val monHoc = "Toan"
    when (monHoc) {
        "Toan" -> println("Môn Toán")
        "Van" -> println("Môn Văn")
        else -> println("Môn chưa rõ")
    }

    // Các kiểu for
    //1
    for (i in 1..8){
        println(i)
    }
    //2 có step
    for (i in 1..8 step 2) {
        println(i)
    }

    //3 for trong danh sách
    val list1 = listOf("toán","văn", "anh", "sử")
    for (item in list1){
        println(item)
    }

    //4 for ngược
    for (i in 8 downTo 0){
        println(i)
    }

    //5 for theo số lượng phần tử
    for (i in list1.indices){
        println("index: $i với giá trị là: ${list1[i]}")
    }

    // While: kiểm tra điều kiện sau đó mới thực thi
    var count = 1
    while (count <5){
        println("count: $count")
        count++
    }
    // do while: thực hiện ít nhất 1 lần sau đó mới kiểm tra điều kiện
    var count2 = 5
    do {
        println("count2: $count2")
    }while (count2 < 5)

    //break: Thoát vòng lặp
    var count3 = 1
    while (count3 < 5){
        if (count3 == 2){
            break
        }
        println("count3: $count3")
        count3++

    }
    //continue: sang vòng lặp tiếp theo luôn
    for (i in 1..5){
        if (i ==2) continue
        println("i: $i")
    }
}