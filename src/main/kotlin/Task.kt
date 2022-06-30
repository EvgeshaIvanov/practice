fun main() {
    val n = readLine()!!.toInt()
    val numbers = (readLine()!!.split(" ").map { it.toInt() }).toIntArray()
    val negative = numbers.filter { it < 0 }
    val positive = numbers.filter { it >= 0 }
    when {
        negative.count() % 2 == 1 -> println(negative.maxOrNull())
        positive.isEmpty() -> println(negative.minOrNull())
        (negative.count() % 2 == 0) || (negative.isEmpty()) -> println(positive.minOrNull())
    }

}