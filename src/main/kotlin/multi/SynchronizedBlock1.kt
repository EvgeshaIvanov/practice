package multi

var counter = 0

class Ex12 {
    fun doWork() {
        println("УРА!")
    }

    fun countered() {
        for (el in 1..3) {
            increment()

        }
    }

    fun increment() {
        doWork()
        synchronized(this) {
            counter++
            println(counter)
        }
    }
}

fun main() {

    val countered = Ex12()

    val thread1 = Thread {
        countered.countered()
    }

    val thread2 = Thread {
        countered.countered()
    }
    val thread3 = Thread {
        countered.countered()
    }

    thread1.start()
    thread2.start()
    thread3.start()
}


