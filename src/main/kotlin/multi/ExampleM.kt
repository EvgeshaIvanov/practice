fun main() {

    val thread1 = Thread(Thread1())
    val thread2 = Thread2()

    thread1.start()
    thread2.start()

    thread2.join()
    thread2.join()

    println("The end!")
}

class Thread2 : Thread() {
    override fun run() {
        for (el in 1..10) {
            sleep(100)
            println("${currentThread()} - $el")
        }
    }
}

class Thread1 : Runnable {
    override fun run() {
        for (el in 1..10) {
            Thread.sleep(100)
            println("${Thread.currentThread()} - $el")
        }
    }
}




