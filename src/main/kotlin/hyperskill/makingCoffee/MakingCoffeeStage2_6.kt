package hyperskill.makingCoffee

/*
Description
Now let's consider a case where you need a lot of coffee. Maybe, for example, you’re hosting a party with a lot of guests. The program should calculate how much water, coffee, and milk are necessary to make the specified amount of coffee. One cup of coffee made on this coffee machine contains 200 ml of water, 50 ml of milk, and 15 g of coffee beans.
The user should input the amount of coffee they need, in cups, for all the guests.
Of course, all this coffee is not needed right now, so at this stage, the coffee machine doesn’t actually make any coffee.
Output example
The example below shows how your output might look.
The symbol > represents the user input. Note that it's not part of the input.

Write how many cups of coffee you will need: > 25
For 25 cups of coffee you will need:
5000 ml of water
1250 ml of milk
375 g of coffee beans
 */
fun main() {
    print("Write how many cups of coffee you will need: 25")
    val offer = readln().toInt()
    println(
        "For $offer cups of coffee you will need:\n" +
                "${offer * 200} ml of water\n" +
                "${offer * 50} ml of milk\n" +
                "${offer * 15} g of coffee beans"
    )

}

