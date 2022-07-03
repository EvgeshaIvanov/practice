package hyperskill.makingCoffee

fun main() {

    val coffeeMachine = CoffeeMachine(400, 540, 120, 9, 550)
    coffeeMachine.startCoffeeMachine()
    coffeeMachine.userActions()

}

data class CoffeeMachine(var water: Int, var milk: Int, var beans: Int, var cups: Int, var money: Int) {

    fun startCoffeeMachine() {

        println(
            "The coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$beans g of coffee beans\n" +
                    "$cups disposable cups\n" +
                    "\$$money of money\n"
        )
    }

    fun userActions() {
        print("Write action (buy, fill, take): ")
        when (readln()) {
            "buy" -> coffeeMachineMenu()
            "fill" -> {
                fillCoffeeMachine()
            }
            "take" -> {
                takeAllMoney()
            }
        }
    }

    private fun coffeeMachineMenu() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        when (readln().toInt()) {
            1 -> {
                purchase(250, 0, 16, 4)
            }
            2 -> {
                purchase(350, 75, 20, 7)
            }
            3 -> {
                purchase(200, 100, 12, 6)
            }
            else -> println("Unknown type of coffee")
        }
        startCoffeeMachine()
    }

    private fun purchase(waterCost: Int, milkCost: Int, beansCost: Int, moneyCost: Int) {
        water -= waterCost
        milk -= milkCost
        beans -= beansCost
        cups -= 1
        money += moneyCost
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
        startCoffeeMachine()
    }

    private fun takeAllMoney() {
        println("I gave you \$$money")
        money = 0
        startCoffeeMachine()
    }

}