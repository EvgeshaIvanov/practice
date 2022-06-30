package hyperskill

/*
Write a program that reads a word and prints the number of characters that appear in it only once.
Sample Input 1:
abracadabra
Sample Output 1:
2
 */
fun main() {

    val str = readln()
    var count = 0
    str.forEach { if (!str.substringAfter(it).contains(it)) count++ }

    println(count)
}
//    for (el in str) {
//        if (!str.substringAfter(el).contains(el)) count++
//    }