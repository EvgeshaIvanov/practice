package leetcode

import kotlin.math.max

fun main() {
    val list = intArrayOf(1, 1, 0, 1, 1, 1)
    println(findMaxConsecutiveOnes(list))
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var counter = 0
    var max = 0
    for (el in nums) {
        if (el == 1) {
            counter += 1
            max = max(max, counter)
        } else counter = 0
    }
    return (max)
}