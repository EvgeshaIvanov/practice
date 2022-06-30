fun main() {

    val list = listOf(10, 232, 12, 34)

    println(list.all { it > 1 })

}

fun evenNumbers(array: List<Int>, number: Int): List<Int> {
    val newList = mutableListOf<Int>()
    array.forEach { el -> if (el % 2 == 0) newList.add(el) }
    return newList.takeLast(number)
}

fun smallEnough(a: IntArray, limit: Int) = a.all { it > limit}

