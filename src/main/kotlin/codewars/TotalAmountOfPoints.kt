package codewars

fun main() {
    println(points(listOf("1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3")))
}

fun points(games: List<String>): Int {

    var counter = 0

    games.forEach {
        counter += if (it[0] > it[2]) {
            3
        } else if (it[0] < it[2]) {
            0
        } else 1
    }
    return counter
}