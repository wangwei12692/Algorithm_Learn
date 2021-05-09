import java.util.*
import kotlin.math.max

class _496 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2)).joinToString())
            println(nextGreaterElement2(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2)).joinToString())
        }

        //暴力
        fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
            val map = mutableMapOf<Int, Int>()
            for ((i, v) in nums2.withIndex())
                map[v] = i
            val ans = IntArray(nums1.size) { -1 }
            for ((i, v) in nums1.withIndex()) {
                for (j in map[v]!! + 1 until nums2.size) {
                    if (nums2[j] > v) {
                        ans[i] = nums2[j]
                        break
                    }
                }
            }
            return ans
        }

        fun nextGreaterElement2(nums1: IntArray, nums2: IntArray): IntArray {
            val m = nums1.size
            val n = nums2.size
            val stack = Stack<Int>()
            val flag = IntArray(n) { -1 }
            val map = mutableMapOf<Int, Int>()
            for (i in 0 until n) {
                map[nums2[i]] = i
                while (stack.isNotEmpty() && nums2[stack.peek()] < nums2[i]) {
                    val last = stack.pop()
                    flag[last] = nums2[i]
                }
                stack.push(i)
            }

            val ans = IntArray(m)
            for (i in 0 until m) {
                ans[i] = flag[map[nums1[i]]!!]
            }
            return ans
        }
    }
}