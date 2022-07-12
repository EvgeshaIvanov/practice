package grokaem

fun main() {

    val list = listOf(1, 3, 5, 7, 9)

    println(binarySearch(list, 3))
}

fun binarySearch(list: List<Int>, item: Int): Int {
    var low = 0
    var high = list.size - 1
    var mid = 0
    var guess = 0
    while (low <= high) {
        mid = (low + high)
        guess = list[mid]
        if (guess == item) {
            return mid
        }
        if (guess > high) {
            high = mid - 1
        } else low = mid + 1
    }
    return 0
}