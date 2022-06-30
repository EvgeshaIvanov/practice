package multi

import java.util.concurrent.locks.ReentrantLock

fun main() {
    val call = Call()
    val thread = Thread {
        call.mobileCall()
    }
    val thread2 = Thread {
        call.skypeCall()
    }
    val thread3 = Thread {
        call.whatsAppCall()
    }
    thread.start()
    thread2.start()
    thread3.start()
}

class Call {
    val lock = ReentrantLock()

    fun mobileCall() {
        lock.lock()
        println("Mobiles call starts")
        Thread.sleep(3000)
        println("Mobiles call ends")
        lock.unlock()
    }

    fun skypeCall() {
        lock.lock()
        println("Skype call starts")
        Thread.sleep(5000)
        println("Skype call ends")
        lock.unlock()
    }

    fun whatsAppCall() {
        lock.lock()
        println("Whats App call starts")
        Thread.sleep(7000)
        println("Mobiles call ends")
        lock.unlock()
    }
}



