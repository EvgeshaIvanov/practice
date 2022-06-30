import java.util.*

object PhoneNumber {
    @JvmStatic
    fun main(args: Array<String>) {
        val correctSymbols = "+()- 0123456789"
        val nums = "0123456789"
        var counter = 0
        var firstCounter = 0
        var secondCounter = 0
        val scanner = Scanner(System.`in`)
        var Number: String
        Number = try {
            scanner.nextLine()
        } catch (e: Exception) {
            println("error")
            scanner.close()
            return
        } finally {
            scanner.close()
        }
        for (i in 0 until Number.length) {
            if (!correctSymbols.contains(Number[i].toString() + "")) {
                println("error")
                scanner.close()
                return
            }
        }
        counter = 0
        for (i in 0 until Number.length) {
            if (nums.contains(Number[i].toString() + "")) {
                counter++
            }
        }
        if (counter != 11) {
            println("error")
            scanner.close()
            return
        }
        Number = Number.replace(" ", "")
        for (i in 0 until Number.length - 1) {
            if (Number[i] == '-' && Number[i + 1] == '-') {
                println("error")
                scanner.close()
                return
            }
        }
        for (i in 0 until Number.length) {
            if (Number[i] == '+' && i != 0) {
                println("error")
                scanner.close()
                return
            }
        }
        if (Number[0] != '+' && Number[0] != '8') {
            println("error")
            scanner.close()
            return
        }
        if (Number[0] == '+' && Number[1] != '7') {
            println("error")
            scanner.close()
            return
        }
        for (i in 0 until Number.length) {
            if (Number[i] == '(') {
                firstCounter++
            }
            if (Number[i] == ')') {
                secondCounter++
            }
        }
        if (!(firstCounter == 0 && secondCounter == 0 || firstCounter == 1 && secondCounter == 1)) {
            println("error")
            scanner.close()
            return
        }
        if (Number[Number.length - 1] == '-') {
            println("error")
            scanner.close()
            return
        }
        if (firstCounter == 1 && secondCounter == 1) {
            if (Number[2] != '(' || Number[6] != ')') {
                println("error")
                scanner.close()
                return
            }
        } else if (Number[0] == '8') {
            if (Number[1] != '(' || Number[5] != ')') {
                println("error")
                scanner.close()
                return
            }
        }
        for (i in 1 until Number.length - 1) {
            if (Number[i] == '(' || Number[i] == ')') {
                if (Number[i - 1] == '-' || Number[i + 1] == '-') {
                    println("error")
                    scanner.close()
                    return
                }
            }
        }
        counter = 0
        for (i in 0 until Number.length) {
            if (nums.contains(Number[i].toString() + "")) {
                counter++
            }
            if (Number[i] == '-' && (counter == 2 || counter == 3)) {
                println("error")
                scanner.close()
                return
            }
        }
        val sb = StringBuilder()
        val start: Int
        start = if (Number[0] == '8') {
            1
        } else {
            2
        }
        sb.append("8 (")
        counter = 0
        for (i in start until Number.length) {
            if (nums.contains(Number[i].toString() + "")) {
                sb.append(Number[i])
                counter++
                if (counter == 3) {
                    sb.append(") ")
                } else if (counter == 6 || counter == 8) {
                    sb.append('-')
                }
            }
        }
        println(sb.toString())
    }
}