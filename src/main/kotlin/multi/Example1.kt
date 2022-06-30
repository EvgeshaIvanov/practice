
var counter = 0

fun main() {

    val thread1 = Thread(R())
    val thread2 = Thread(R())
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()

    println(counter)


}

class Ex11 {

    @Synchronized fun increment() {
        counter++
    }
}


class R : Runnable {
    override fun run() {
        for (el in 1..100) {
            Ex11().increment()
        }
    }
}