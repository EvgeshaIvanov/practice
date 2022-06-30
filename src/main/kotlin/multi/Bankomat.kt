package multi

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class Bankomat {

    val lock = ReentrantLock()
    val sasha = Employee("Sasha", lock)


}

fun main() {
    val thread = Thread().isDaemon
    val lock = ReentrantLock()
    Employee("Sasha", lock)
    Employee("Alena", lock)
    Employee("Alex", lock)
    Thread.sleep(5000)
    Employee("Masha", lock)
    Employee("Stas", lock)
}


class Employee(val nameEmployee: String, val lock: Lock) : Thread() {

    init {
        this.start()
    }

    override fun run() {
        if (lock.tryLock()) {

//        println("$nameEmployee ждет...")
//        lock.lock()
            println("$nameEmployee пользуется банкоматом")
            sleep(2000)
            println("$nameEmployee завершил свои дела")
            lock.unlock()
        } else
            println("$nameEmployee не хочет ждать в очереди")
    }
}