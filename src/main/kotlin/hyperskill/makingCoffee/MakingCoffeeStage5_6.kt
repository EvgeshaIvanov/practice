package hyperskill.makingCoffee

fun main() {

    val coffeeMachine = CoffeeMachine(400, 540, 120, 9, 550)
    while (!coffeeMachine.exit) {
        coffeeMachine.userActions()
    }

}

data class CoffeeMachine(var water: Int, var milk: Int, var beans: Int, var cups: Int, var money: Int) {
    var exit = false
    fun userActions() {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (readln()) {
            "buy" -> coffeeMachineMenu()
            "fill" -> {
                fillCoffeeMachine()
            }
            "take" -> {
                takeAllMoney()
            }
            "remaining" -> {
                conditionCoffeeMachine()
            }
            "exit" -> {
                exit = true
            }
            else -> {
                println("Unknown type of action")
            }
        }
    }

    private fun conditionCoffeeMachine() {
        println(
            "The coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$beans g of coffee beans\n" +
                    "$cups disposable cups\n" +
                    "\$$money of money\n"
        )
    }

    private fun coffeeMachineMenu() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when (readln()) {
            "1" -> {
                purchase(250, 0, 16, 4)
            }
            "2" -> {
                purchase(350, 75, 20, 7)
            }
            "3" -> {
                purchase(200, 100, 12, 6)
            }
            "back" -> {
                userActions()
            }
            else -> println("Unknown type of coffee")
        }
    }

    private fun purchase(waterCost: Int, milkCost: Int, beansCost: Int, moneyCost: Int) {
        if (water - waterCost < 0) println("Sorry, not enough water!")
        else if (milk - milkCost < 0) println("Sorry, not enough milk!")
        else if (beans - beansCost < 0) println("Sorry, not enough beans!")
        else if (cups - 1 < 0) println("Sorry, not enough cups!")
        else {
            water -= waterCost
            milk -= milkCost
            beans -= beansCost
            cups -= 1
            money += moneyCost
            println("I have enough resources, making you a coffee!")
        }
    }

    private fun fillCoffeeMachine() {
        print("Write how many ml of water do you want to add: ")
        water += readln().toInt()
        print("Write how many ml of milk do you want to add: ")
        milk += readln().toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        beans += readln().toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        cups += readln().toInt()

    }

    private fun takeAllMoney() {
        println("I gave you \$$money")
        money = 0
    }

}