package multi

class VolatileEx : Thread() {
    @Volatile
    var b: Boolean = true

    override fun run() {
        var counter: Long = 0
        while (b) {
            counter++
        }
        println("Loop is finished, counter = $counter")
    }
}

fun main() {

    val thread = VolatileEx()
    thread.start()
    Thread.sleep(3000)
    println("After 3 seconds it is time to wake up!")
    thread.b = false
    thread.join()
    println("End of program")


}