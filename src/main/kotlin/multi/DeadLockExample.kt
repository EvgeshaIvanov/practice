package multi

fun main() {

    val thread10 = Thread10()
    val thread20 = Thread20()

    thread10.start()
    thread20.start()
}

class DeadLockExample {

    val lock1 = Any()
    val lock2 = Any()

}

class Thread10 : Thread() {
    override fun run() {
        println("Thread10: попытка захватить монитор lock1")
        synchronized(DeadLockExample().lock1) {
            println("Thread10:монитор объекта lock1 захвачен")
            println("Thread10: попытка захватить монитор lock2")
            synchronized(DeadLockExample().lock2) {
                println("монитор объекта lock1 и lock2 захвачены")
            }
        }
    }
}

class Thread20 : Thread() {
    override fun run() {
        println("Thread20: попытка захватить монитор lock1")
        synchronized(DeadLockExample().lock2) {
            println("Thread20:монитор объекта lock2 захвачен")
            println("Thread20: попытка захватить монитор lock1")
            synchronized(DeadLockExample().lock1) {
                println("монитор объекта lock1 и lock2 захвачены")
            }
        }
    }
}