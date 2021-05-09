import java.util.*
import kotlin.math.max

class _239 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(maxSlidingWindow(intArrayOf(1,-1), 1).joinToString())
        }

        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            val ans = IntArray(nums.size - k + 1)
            var preMax = Int.MIN_VALUE
            val map = TreeMap<Int, Int>()
            for (i in nums.lastIndex downTo nums.lastIndex - k + 1) {
                preMax = max(nums[i], preMax)
                map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
            }
            ans[ans.lastIndex] = preMax
            for (i in nums.lastIndex - k downTo 0) {
                val pre = map[nums[i + k]]
                if (pre == 1) {
                    map.remove(nums[i + k])
                } else {
                    map[nums[i + k]] = pre!! - 1
                }
                map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
                ans[i] = map.floorEntry(Int.MAX_VALUE).key
            }
            return ans
        }
    }
}