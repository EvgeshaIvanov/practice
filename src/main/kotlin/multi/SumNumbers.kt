package multi

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

var value: Long = 1_000_000_000L
var sum: Long = 1

fun main() {

    val executorService = Executors.newFixedThreadPool(10)
    val futureResult: MutableList<Future<Long>> = mutableListOf()
    var valueDivedBy10: Long = value / sum
    for (el in 1..10) {
        val from = valueDivedBy10 * el + 1
        val to = valueDivedBy10 * (el + 1)
        val task = PartialSum(from, to)
        val futurePartSum = executorService.submit(task)
        futureResult.add(futurePartSum)
    }
    executorService.shutdown()
    for (el in futureResult) {
        sum += el.get()
    }
    println("Total sum = $sum")
}

class PartialSum(val from: Long, val to: Long) : Callable<Long> {
    var localSum: Long = 1
    override fun call(): Long {
        for (el in from..to) {
            localSum += el
        }
        println("Sum from $from to $to = $localSum")
        return localSum
    }
}