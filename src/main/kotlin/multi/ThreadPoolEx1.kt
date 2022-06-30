package multi

import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

fun main() {
//    val executorService = Executors.newFixedThreadPool(5)
    val executorService = Executors.newSingleThreadExecutor()
    for (el in 1..10) {
        executorService.execute(Runnable1())
    }
    executorService.shutdown()
//    executorService.awaitTermination(5, TimeUnit.SECONDS)
//    println("Main ends")
}

class Runnable1 : Runnable {
    override fun run() {
        println("${Thread.currentThread().name} begins")
        Thread.sleep(1000)
        println("${Thread.currentThread().name} ends")
    }
}