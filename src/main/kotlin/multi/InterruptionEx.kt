package multi

class InterruptionEx {
}

fun main() {
    val thread = InterruptedThread()
    println("Main starts")
    thread.start()
    Thread.sleep(2000)
    thread.interrupt()
    thread.join()
    println("Main ends")
}

class InterruptedThread : Thread() {

    var sqrtSum: Double = 0.0

    override fun run() {
        for (el in 1..1000000000) {
            if (isInterrupted) {
                println("Поток хотят прервать")
                println("Решили завершить поток")
                return
            } else sqrtSum += Math.sqrt(el.toDouble())
        }
        println(sqrtSum)
    }
}