fun main() {


    val list = listOf(1, 12323, 1909, 123)

    var max = list[0]
    var min = list[0]

    for (el in list) {
        if (el > max) {
            max = el
        }
        if (el < min) {
            min = el
        }
    }
    println("max = $max, min = $min")

}