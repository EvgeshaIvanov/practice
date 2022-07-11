package leetcode

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val nums1 = intArrayOf(3, 2, 4)
    val nums2 = intArrayOf(3, 3)

    println(twoSum(nums, 9).joinToString(prefix = "[", separator = ", ", postfix = "]"))
    println(twoSum(nums1, 6).joinToString(prefix = "[", separator = ", ", postfix = "]"))
    println(twoSum(nums2, 6).joinToString(prefix = "[", separator = ", ", postfix = "]"))

}

fun twoSum(nums: IntArray, target: Int): IntArray {

    val arr = mutableListOf<Int>()

    for ((index, el) in nums.withIndex()) {
        for ((i, j) in nums.withIndex()) {
            if (el + j == target && index != i) {
                arr.add(index)
                arr.add(i)
                return arr.toIntArray()
            }
        }
    }
    return arr.toIntArray()
}