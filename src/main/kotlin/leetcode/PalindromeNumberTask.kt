package leetcode

fun main() {

    println(isPalindrome(10))
}

fun isPalindrome(x: Int) = x.toString() == x.toString().reversed()
