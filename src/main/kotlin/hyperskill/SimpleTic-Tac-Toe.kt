package hyperskill

fun String.onlyLetters(): Boolean = (firstOrNull { !it.isLetter() } == null)
val str = MutableList(9) { '_' }

fun main() {

    println(
        "---------\n" +
                "|       |\n" +
                "|       |\n" +
                "|       |\n" +
                "---------"
    )

    while (!gameIsFinished()) {
        if (!gameIsFinished()) {
            makeMoveFirstPlayer()
        } else break
        if (!gameIsFinished()) {
            makeMoveSecondPlayer()
        } else break

    }

}

fun makeMoveFirstPlayer(): Boolean {
    var a = ""
    var b = ""
    do {
        var temp = 0
        print("Enter the coordinates: ")
        val coordinates = readln().split(' ').toMutableList() //ввели координаты
        a = coordinates[0]
        b = coordinates[1]
        if (a.onlyLetters() && b.onlyLetters()) {
            println("You should enter numbers!")
            temp++
        } else if (!checkNumbers(a.toInt(), b.toInt())) {
            println("Coordinates should be from 1 to 3!")
            temp++
        } else if (!isEmptyCell(a.toInt(), b.toInt(), str)) {
            println("This cell is occupied! Choose another one!")
            temp++
        }

    } while (temp > 0 && gameIsFinished())

    coordinatorX(a.toInt(), b.toInt(), str)

    printField()

    return true
}

fun makeMoveSecondPlayer(): Boolean {
    var a = ""
    var b = ""
    do {
        var temp = 0
        print("Enter the coordinates: ")
        val coordinates = readln().split(' ').toMutableList() //ввели координаты
        a = coordinates[0]
        b = coordinates[1]
        if (a.onlyLetters() && b.onlyLetters()) {
            println("You should enter numbers!")
            temp++
        } else if (!checkNumbers(a.toInt(), b.toInt())) {
            println("Coordinates should be from 1 to 3!")
            temp++
        } else if (!isEmptyCell(a.toInt(), b.toInt(), str)) {
            println("This cell is occupied! Choose another one!")
            temp++
        }

    } while (temp > 0 && gameIsFinished())

    coordinatorO(a.toInt(), b.toInt(), str)

    printField()

    return true
}

fun coordinatorO(x: Int, y: Int, str: MutableList<Char>): MutableList<Char> {
    if (x == 1 && y == 1) str[0] = 'O'
    else if (x == 1 && y == 2) str[1] = 'O'
    else if (x == 1 && y == 3) str[2] = 'O'
    else if (x == 2 && y == 1) str[3] = 'O'
    else if (x == 2 && y == 2) str[4] = 'O'
    else if (x == 2 && y == 3) str[5] = 'O'
    else if (x == 3 && y == 1) str[6] = 'O'
    else if (x == 3 && y == 2) str[7] = 'O'
    else if (x == 3 && y == 3) str[8] = 'O'
    return str
}

fun coordinatorX(x: Int, y: Int, str: MutableList<Char>): MutableList<Char> {
    if (x == 1 && y == 1) str[0] = 'X'
    else if (x == 1 && y == 2) str[1] = 'X'
    else if (x == 1 && y == 3) str[2] = 'X'
    else if (x == 2 && y == 1) str[3] = 'X'
    else if (x == 2 && y == 2) str[4] = 'X'
    else if (x == 2 && y == 3) str[5] = 'X'
    else if (x == 3 && y == 1) str[6] = 'X'
    else if (x == 3 && y == 2) str[7] = 'X'
    else if (x == 3 && y == 3) str[8] = 'X'
    return str
}

fun printField() {
    println(
        "---------\n" +
                "| ${str[0]} ${str[1]} ${str[2]} |\n" +
                "| ${str[3]} ${str[4]} ${str[5]} |\n" +
                "| ${str[6]} ${str[7]} ${str[8]} |\n" +
                "---------"
    )
}

fun gameIsFinished(): Boolean {
    var x = str.count { it == 'X' }
    var o = str.count { it == 'O' }
    var xInRow =
        ((str[0] == 'X' && str[1] == 'X' && str[2] == 'X') || (str[3] == 'X' && str[4] == 'X' && str[5] == 'X')
                || (str[6] == 'X' && str[7] == 'X' && str[8] == 'X') || (str[0] == 'X' && str[3] == 'X' && str[6] == 'X') ||
                (str[1] == 'X' && str[4] == 'X' && str[7] == 'X') || (str[2] == 'X' && str[5] == 'X' && str[8] == 'X')
                || (str[0] == 'X' && str[4] == 'X' && str[8] == 'X') || (str[2] == 'X' && str[4] == 'X' && str[6] == 'X'))


    var oInRow = ((str[0] == 'O' && str[1] == 'O' && str[2] == 'O') || (str[3] == 'O' && str[4] == 'O' && str[5] == 'O')
            || (str[6] == 'O' && str[7] == 'O' && str[8] == 'O') || (str[0] == 'O' && str[3] == 'O' && str[6] == 'O') ||
            (str[1] == 'O' && str[4] == 'O' && str[7] == 'O') || (str[2] == 'O' && str[5] == 'O' && str[8] == 'O')
            || (str[0] == 'O' && str[4] == 'O' && str[8] == 'O') || (str[2] == 'O' && str[4] == 'O' && str[6] == 'O'))

    var emptySpace = !str.contains('_')

    if (xInRow && oInRow || (x - o) >= 2 || (o - x) >= 2) println("Impossible")
    else if (xInRow) {
        print("X wins")
        return true
    } else if (oInRow) {
        print("O wins")
        return true
    } else if (xInRow || oInRow || emptySpace) {
        print("Draw")
        return true
    }
    return false
}

fun checkNumbers(a: Int, b: Int): Boolean {
    return a in 1..3 && b in 1..3
}

fun isEmptyCell(x: Int, y: Int, str: MutableList<Char>): Boolean {

    return (((x == 1) && (y == 1) && (str[0] == '_')) || ((x == 1) && (y == 2) && (str[1] == '_')) || ((x == 1) && (y == 3) && (str[2] == '_'))
            || ((x == 2) && (y == 1) && (str[3] == '_')) || ((x == 2) && (y == 2) && (str[4] == '_')) || ((x == 2) && (y == 3) && (str[5] == '_'))
            || ((x == 3) && (y == 1) && (str[6] == '_')) || ((x == 3) && (y == 2) && (str[7] == '_')) || ((x == 3) && (y == 3) && (str[8] == '_')))
}