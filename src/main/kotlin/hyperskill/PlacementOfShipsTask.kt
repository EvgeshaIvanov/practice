package hyperskill
/*
Sample Input 1:
1 2
2 3
4 1

_ 1 _ _ _
_ _ 2 _ _
_ _ _ _ _
3 _ _ _ _
_ _ _ _ _
Sample Output 1:
3 5 (строки 3 и 5 свободные)
4 5 (столбцы 4 и 5 свободные)
 */


fun main() {
    val firstShip = readln().split(" ") // х первый, y первый
    val secondShip = readln().split(" ") // х второй, y второй
    val thirdShip = readln().split(" ") // х третий, y третий
    val xField = listOf(1, 2, 3, 4, 5)
    val yField = listOf(1, 2, 3, 4, 5)
    val xFreeField = mutableListOf<Int>()
    val yFreeField = mutableListOf<Int>()
    for (el in xField) {
        if (el == firstShip[0].toInt()
            || el == secondShip[0].toInt()
            || el == thirdShip[0].toInt()
        ) {
            continue
        } else {
            xFreeField.add(el)
        }
    }
    for (el in yField) {
        if (el == firstShip[1].toInt()
            || el == secondShip[1].toInt()
            || el == thirdShip[1].toInt()
        ) {
            continue
        } else {
            yFreeField.add(el)
        }
    }

    println(xFreeField.joinToString(" "))
    println(yFreeField.joinToString(" "))
}