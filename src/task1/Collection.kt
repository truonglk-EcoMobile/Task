package task1

fun main(){
    demoList()
    demoSet()
    demoMap()
    demoFuncOfCollection()
}

//List
fun demoList(){
    var list = listOf("d", "b", "c", "a") //không thể thay đổi
    println(list)

    var mutableList = mutableListOf(1,2,3,4,5) //có thể thay đổi
    println("mutableList = $mutableList")
    mutableList.add(6)
    println("mutableList sau khi add = $mutableList")
    mutableList.removeAt(2)
    mutableList.removeAt(0)
    println("mutableList sau khi remove = $mutableList")
}

//set
fun demoSet(){
    var set = setOf(1,2,3,4,5,1) //Chứa giá trị không trùng lặp cho nên 1 ở cuối sẽ bị loại bỏ
    println("set = $set")
}

//map
fun demoMap(){
    var map = mapOf(1 to "one", 2 to "two", 3 to "three")
    println("map = $map")
    println("các key của map = ${map.keys}")
    println("các giá trị của map = ${map.values}")
    println("map.constainsKey: ${map.containsKey(2)}")
    println("map.constainsValue: ${map.containsValue("three")}")
}

//các hàm của collection
fun demoFuncOfCollection(){
    val list = mutableListOf(1,2,3,4,5,1)
    val list2 = mutableListOf(5,6,7,8,9)
    println("size = ${list.size}") //độ dài của list
    println("count = ${list.count()}") //đếm số phần tử của list
    println("joinToString = ${list.joinToString("-")}") // nối thành một chuỗi với ký tự nào đó
    println("distinct = ${list.distinct()}") //loại trùng
    println("union = ${list.union(list2)}") //hợp 2 list bỏ trùng
    println("intersec = ${list.intersect(list2)}") //hợp 2 list lấy trùng
    println("subtract = ${list.subtract(list2)}") //có trong list ko có trong list2
    println("contains = ${list.contains(2)}") //kiểm tra có trong list ko
    println("isEmpty = ${list.isEmpty()}") //kiểm tra rỗng
    println("map: ${list.map{it * 2}}") //biến đổi các phần tử trong list
    println("filter: ${list.filter{it % 2 == 0}}") //lọc các phần tử thỏa man điều kiện trong list
    println("reduce: ${list.reduce{acc,it -> acc+it}}") //gộp các phần tử thành một theo công thức
    println("forEach:") //lặp qua các phần tử trong list
    list.forEach{it->
        println(it)
    }
    println("Phần tử đầu: ${list.first()}")
    println("Phần tử cuối: ${list.last()}")

    val listChuaSapXep = listOf(5,6,1,7,0,2,9,2)
    println("sorted: ${listChuaSapXep.sorted()}") //sắp xếp tăng dần
    println("soredDescending: ${listChuaSapXep.sortedDescending()}") //sắp xếp giảm dần
    println("distinct: ${listChuaSapXep.distinct()}") //Loại trung lap
    println("any >3 ${listChuaSapXep.any { it > 3}}") // ít nhất 1 phần tử thỏa mãn điều kiện
    println("all >0 ${listChuaSapXep.all { it > 0}}") // tất cả thỏa mãn điều kiện
    println("group by ${listChuaSapXep.groupBy { if (it %2 ==0) "chẵn" else "lẻ" }}")
    println("avg: ${listChuaSapXep.average()}") //trung bình cộng
    println("max: ${listChuaSapXep.max()}") //phần tử lớn nhất
    println("min: ${listChuaSapXep.min()}") // phần tử nhỏ nhất
    println("sum: ${listChuaSapXep.sum()}") //tổng các phần tử
    println("take 3: ${listChuaSapXep.take(3)}") // lấy 3 phần tử đầu
    println("takeLast 3: ${listChuaSapXep.takeLast(3)}") // lấy 3 phần tử cuối
    println("drop 3: ${listChuaSapXep.drop(3)}") // bỏ 3 pần tử đầu
    listChuaSapXep.reversed() //đảo ngược danh sách
    println("Danh sách sau khi đảo ngược: $listChuaSapXep")
    println("random 1 số trong danh sách: ${listChuaSapXep.random()}")
    println("Chuyển danh sách thành chuỗi: ${listChuaSapXep.joinToString(prefix = "{", postfix = "}",separator = "+")}")
    println("phần tử đầu hoặc null: ${listChuaSapXep.firstOrNull()}")
    println("phần tử cuối hoặc null: ${listChuaSapXep.lastOrNull()}")
    println("danh sách mới lấy từ danh sách cũ từ vị trí 1 đến 3 ${listChuaSapXep.slice(1..3)}")
}