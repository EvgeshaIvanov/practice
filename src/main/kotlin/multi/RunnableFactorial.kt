package multi

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

var factorialResult = 0

fun main() {

    val executorService = Executors.newSingleThreadExecutor()
    val factorial = Factorial(5)
    executorService.execute(factorial)
    executorService.shutdown()
    executorService.awaitTermination(10, TimeUnit.SECONDS)
    println(factorialResult)
}


class Factorial(val f: Int) : Runnable {
    override fun run() {
        if (f <= 0) {
            println("Неверное число")
            return
        }
        var result = 1
        for (el in 1..f) {
            result *= el
        }
        factorialResult = result
    }
}