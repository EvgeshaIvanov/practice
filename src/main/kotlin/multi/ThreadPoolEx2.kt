package multi

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

fun main() {

    val executorService = Executors.newScheduledThreadPool(1)
//    for (el in 1..10){
//        executorService.execute(Runnable2())
////    }
//    executorService.schedule(Runnable2(), 3, TimeUnit.SECONDS)
//    executorService.shutdown()
//    executorService.scheduleAtFixedRate(Runnable2(), 3, 1, TimeUnit.SECONDS)
//    Thread.sleep(20000)
    executorService.scheduleWithFixedDelay(Runnable2(), 3, 1, TimeUnit.SECONDS)
    executorService.shutdown()

    val executorService1 = Executors.newCachedThreadPool()

}

class Runnable2 : Runnable {
    override fun run() {
        println("${Thread.currentThread().name} begins")
        Thread.sleep(3000)
        println("${Thread.currentThread().name} ends")
    }
}