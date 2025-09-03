fun main(){

    // list
    var list = listOf(1,2,3,4,5) //không thể thay đổi
    var mutableList = mutableListOf(1,2,3,4,5) //có thể thay đổi
    println("mutableList = $mutableList")
    mutableList.add(6)
    println("mutableList sau khi add = $mutableList")

    //set
    var set = setOf(1,2,3,4,5,1) //Chứa giá trị không trùng lặp cho nên 1 ở cuối sẽ bị loại bỏ
    println("set = $set")

    var map = mapOf(1 to "one", 2 to "two", 3 to "three")
    println("map = $map")

    //Các hàm trong collection
    println("size = ${list.size}") //độ dài của list
    println("map: ${list.map{it * 2}}") //biến đổi các phần tử trong list
    println("filter: ${list.filter{it % 2 == 0}}") //lọc các phần tử thỏa man điều kiện trong list
    println("reduce: ${list.reduce{acc,it -> acc+it}}") //gộp các phần tử thành một
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
    println("drop 3: ${listChuaSapXep.drop(3)}") // bỏ 3 pần tử đầu
}