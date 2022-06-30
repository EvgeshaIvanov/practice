package multi

import java.util.concurrent.CountDownLatch

var countDownLatch = CountDownLatch(3)
fun main() {
    marketStaffIsOnPlace()
    everythingIsReady()
    openMarket()
    Friend("ALex", countDownLatch)
    Friend("Misha", countDownLatch)
    Friend("Sashs", countDownLatch)

}

fun marketStaffIsOnPlace() {
    Thread.sleep(2000)
    println("Market staff came to work")
    countDownLatch.countDown()
    println("countDownLatch = ${countDownLatch.count}")
}

fun everythingIsReady() {
    Thread.sleep(3000)
    println("Everything is ready, so lets open market")
    countDownLatch.countDown()
    println("countDownLatch = ${countDownLatch.count}")
}

fun openMarket() {
    Thread.sleep(4000)
    println("Market is open")
    countDownLatch.countDown()
    println("countDownLatch = ${countDownLatch.count}")
}

class Friend(val name3: String, val countDownLatch: CountDownLatch) : Thread() {
    init {
        this.start()
    }

    override fun run() {
        countDownLatch.await()
        println("$name3 приступила к закупкам")
    }
}

