package hyperskill.makingCoffee


fun main() {
    print("Write how many ml of water the coffee machine has: ")
    val water = readln().toInt()
    print("Write how many ml of milk  the coffee machine has: ")
    val milk = readln().toInt()
    print("Write how many grams of coffee beans the coffee machine has: ")
    val beans = readln().toInt()
    print("Write how many cups of coffee you will need: ")
    val cups = readln().toInt()
    val totalCoffee = totalCount(water, milk, beans)
    if (!validate(water, milk, beans)) {
        if (cups == 0) {
            println("Yes, I can make that amount of coffee ")
        } else
            println("No, I can make only 0 cups of coffee")
    } else {
        if (totalCoffee - cups < 0) {
            println("No, I can make only $totalCoffee cups of coffee")
        } else if (cups == totalCoffee) {
            println("Yes, I can make that amount of coffee")
        } else {
            println(
                "Yes, I can make that amount of coffee (and even $totalCoffee more than that)"
            )
        }
    }
}

fun totalCount(water: Int, milk: Int, beans: Int): Int {

    val minCounter = minOf(water / 200, milk / 50, beans / 15)

    if (milk / 50 >= minCounter && beans / 15 >= minCounter && water / 200 >= minCounter) {
        return minCounter
    }
    return 0
}


fun validate(water: Int, milk: Int, beans: Int): Boolean {
    return water >= 200 && milk >= 50 && beans >= 15
}

//class CoffeeFactory {
//    fun create(water: Int, milk: Int, beans: Int): Int {
//        return minOf(water / 200, milk / 50, beans / 15)
//    }
//    val coffeeFactory = CoffeeFactory()
//
//    val cup = coffeeFactory.create(200, 50, 15)
//    println(cup)
//}