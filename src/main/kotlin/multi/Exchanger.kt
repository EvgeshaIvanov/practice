package multi

import java.util.concurrent.Exchanger

fun main() {
    val exchanger = Exchanger<Action>()
    val friendAction = mutableListOf<Action>()
    friendAction.add(Action.CUTTER)
    friendAction.add(Action.PAPER)
    friendAction.add(Action.CUTTER)
    val friendAction2 = mutableListOf<Action>()
    friendAction2.add(Action.PAPER)
    friendAction2.add(Action.STONE)
    friendAction2.add(Action.STONE)

    BestFriend("ivan", exchanger, friendAction)
    BestFriend("Sasha", exchanger, friendAction2)


}


enum class Action {
    STONE, CUTTER, PAPER
}

class BestFriend(val name4: String, val exchanger: Exchanger<Action>, val myActions: List<Action>) : Thread() {

    init {
        this.start()
    }

    fun whoWins(myAction: Action, friendAction: Action) {
        if (myAction == Action.STONE && friendAction == Action.CUTTER
            || myAction == Action.CUTTER && friendAction == Action.PAPER
            || myAction == Action.PAPER && friendAction == Action.STONE
        ) {
            println("$name4 wins")
        }
    }

    override fun run() {
        var reply: Action?
        for (el in myActions) {
            reply = exchanger.exchange(el)
            whoWins(el, reply)
            sleep(2000)
        }
    }
}