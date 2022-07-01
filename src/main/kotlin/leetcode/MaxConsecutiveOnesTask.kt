package leetcode

fun main() {

    val list = listOf(1, 1, 0, 1, 1, 1)
    var counter = 0
    val res = list.joinToString("")
    println(res.filter { it.toString().substringAfter('O') == "1" })
    for (el in list) {
        if (el.toString().substringAfter("0") == "1") {
            counter++
        }
    }
    println(counter)
}