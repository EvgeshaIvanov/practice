package multi

class DaemonExample {
}

fun main() {
    val userThread = UserThread()
    userThread.name = "userThread"
    val daemonThread = DaemonThread()
    daemonThread.name = "daemonThread"
    daemonThread.isDaemon = true
    println("Main thread starts")

    userThread.start()
    daemonThread.start()

    println("Main thread ends")
}

class UserThread : Thread() {
    override fun run() {
        println("${currentThread().name} is daemon: $isDaemon")
        for (el in 'A'..'J') {
            sleep(300)
            println(el)
        }
    }
}

class DaemonThread : Thread() {
    override fun run() {
        println("${currentThread().name} is daemon: $isDaemon")
        for (el in 1..1000) {
            sleep(100)
            println(el)
        }
    }
}