package grokaem

fun main() {
    val arr = arrayListOf(8, 10, 14, 40, 5, 13)
    println(findSmallest(arr))
    val newArr = selectionSort(arr)
    println(newArr.joinToString(","))
}

fun findSmallest(arr: ArrayList<Int>): Int {
    var smallest = arr[0]
    var smallestIndex = 0
    for (el in arr.indices) {
        if (arr[el] < smallest) {
            smallest = arr[el]
            smallestIndex = el
        }
    }
    return smallestIndex
}

fun selectionSort(arr: ArrayList<Int>): IntArray {
    var smallest = 0
    var array = emptyArray<Int>()
    for (el in arr.indices) {
        smallest = findSmallest(arr)
        array += arr[smallest].also { arr.removeAt(smallest) }
    }
    return array.toIntArray()
}