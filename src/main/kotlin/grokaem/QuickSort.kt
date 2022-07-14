package grokaem

fun main() {

    println(quickSort(arrayOf(1, 54, 10,4, 11, 12)).joinToString(","))

}

fun quickSort(arr: Array<Int>): Array<Int> {
    var greater = emptyArray<Int>()
    var less = emptyArray<Int>()
    if (arr.size <= 1) {
        return arr
    } else if (arr.size <= 2) {
        for (el in arr.indices) {
            if (arr[el] > arr[el + 1]) {
                arr[el] = arr[el + 1].also { arr[el + 1] = arr[el] }
            }
            return arr
        }
    } else {
        val pivot = arr[arr.size / 2]
        for (el in arr.indices) {
            if (arr[el] > pivot) {
                greater += arr[el]
            } else if (arr[el] < pivot) {
                less += arr[el]
            }
        }
        return quickSort(less) + pivot + quickSort(greater)
    }
    return emptyArray()
}