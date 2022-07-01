package patterns

fun main() {

}

interface Observer {
    fun handleTask()
}

interface Observable {

    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()

}