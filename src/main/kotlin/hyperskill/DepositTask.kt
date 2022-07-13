package hyperskill

import kotlin.math.pow

fun main() {

    when (readln()) {
        "amount" -> println(finalAmount(amount = readln().toInt()))
        "percent" -> println(finalAmount(percent = readln().toInt()))
        "years" -> println(finalAmount(years = readln().toInt()))
    }

}

fun finalAmount(amount: Int = 1000, percent: Int = 5, years: Int = 10): Int {

    return (amount * (1 + percent.toDouble() / 100).pow(years.toDouble())).toInt()

}