package multi

import java.util.concurrent.Callable
import java.util.concurrent.Executors

var factorialResult1 = 0

fun main() {

    val executorService = Executors.newSingleThreadExecutor()
    val factorial2 = Factorial2(5)
    val future = executorService.submit(factorial2)
    println(future.isDone)
    println("Хотим получить результат")
    factorialResult1 = future.get()
    println("Получили результат")
    println(future.isDone)
    executorService.shutdown()
    println(factorialResult1)

}


class Factorial2(private val f2: Int) : Callable<Int> {

    override fun call(): Int {
        if (f2 <= 0) {
            throw Exception("вы ввели неверное число")
        }
        var result = 1
        for (el in 1..f2) {
            result *= el
            Thread.sleep(1000)
        }
        return result
    }
}