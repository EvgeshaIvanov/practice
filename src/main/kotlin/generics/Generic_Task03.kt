package generics

fun main() {

    val list = listOf(1, 2, 123, 4, 14)
    println(getSecondElement(list))
    val strList = listOf("Some", "TODO", "WORK")
    println(getSecondElement(strList))
}


fun <T> getSecondElement(list: List<T>): T {
    return list[1]
}

