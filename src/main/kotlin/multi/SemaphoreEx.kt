package multi

import java.util.concurrent.Semaphore

fun main() {
    val callBox = Semaphore(2)

    Person("Alex", callBox)
    Person("Misha", callBox)
    Person("Sasha", callBox)
    Person("Masha", callBox)

}


class Person(val name2: String, val callBox: Semaphore) : Thread(){

    init {
        this.start()
    }
    override fun run() {
        println("$name2 ждет...")
        callBox.acquire()
        println("$name2 пользуется телефоном")
        sleep(2000)
        println("$name2 завершил звонок")
        callBox.release()
    }
}