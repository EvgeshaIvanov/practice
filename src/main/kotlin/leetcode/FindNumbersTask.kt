package leetcode

fun main() {

    val list = listOf(12, 345, 2, 6, 7896)
    var counter = 0
    list.forEach { if (it.toString().length % 2 == 0) counter++ }

    println(counter)

}

