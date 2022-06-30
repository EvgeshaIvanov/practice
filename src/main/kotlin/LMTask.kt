import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlin.coroutines.CoroutineContext

suspend fun main() = coroutineScope{

    val job = launch {
        produce<String> {

        }
        for(i in 1..5){
            println(i)
            delay(400L)
        }
        launch {
            println("Статус корутины -  ${Thread.currentThread().name}")
        }
    }

    println("Start")
    job.join() // ожидаем завершения корутины
    println("End")
    println("Статус корутины -  ${Thread.currentThread().name}")
}