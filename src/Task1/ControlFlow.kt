package Task1

fun main(){
    demoCondition()
    demoFor()
    demoWhen(2)
    demoWhile()
    demoDoWhile()
    demoBreak()
    demoContinue()
}

//điều kiện
fun demoCondition(){
    val a = 8
    val b = 10
    if (a > b) {
        println("a lớn hơn b")
    }else if (a == b) {
        println("a bằng b")
    }else{
        println("a nhỏ hơn b")
    }
}

//for
fun demoFor(){
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
}

//When
fun demoWhen(so: Int){
    when (so) {
        in 1..5 ->{
            println("số từ 1 đến 5")
        }
        in 6..10 ->{
            println("số từ 6 đến 10")
        }
        else -> {
            println("số lớn hơn 10")
        }
    }
}

//While
fun demoWhile(){
    var count = 1
    while (count <5){
        println("count: $count")
        count++
    }
}

//do-while
fun demoDoWhile(){
    var count2 = 5
    do {
        println("count2: $count2")
    }while (count2 < 5)
}

//break: Thoát vòng lặp
fun demoBreak(){
    var count3 = 1
    while (count3 < 5){
        if (count3 == 2){
            break
        }
        println("count3: $count3")
        count3++

    }
}

//continue: sang vòng lặp tiếp theo luôn
fun demoContinue(){
    for (i in 1..5){
        if (i ==2) continue
        println("i: $i")
    }
}