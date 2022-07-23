package hyperskill

fun main() {
    val expected = readln().toInt()
    val limit = readln()
    checkSpeed(expected, limit)
}


fun checkSpeed(expected: Int, limit: String = "60") {
    when (limit) {
        "no limit" -> if (expected > 60) {
            val div = expected - 60
            println("Exceeds the limit by $div kilometers per hour")
        } else {
            println("Within the limit")
        }
        else -> if (expected > limit.toInt()) {
            val div = expected - limit.toInt()
            println("Exceeds the limit by $div kilometers per hour")
        } else println("Within the limit")
    }

}