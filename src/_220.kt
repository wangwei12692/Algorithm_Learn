import java.util.*
import kotlin.math.abs

class _220 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(containsNearbyAlmostDuplicate2(intArrayOf(2147483640, 2147483641), 1, 100))
        }

        data class D(val vDiff: Int, val iDiff: Int)

        fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
            val data = mutableListOf<D>()
            for (i in nums.indices) {
                for (j in i + 1 until nums.size) {
                    if (abs(nums[i] - nums[j]) <= t && j - i <= k) {
                        return true
                    }
                }
            }
            return false
        }

        fun containsNearbyAlmostDuplicate2(nums: IntArray, k: Int, t: Int): Boolean {
            val set = TreeSet<Int>()
            for (i in nums.indices) {
                val s = set.ceiling(nums[i])
                if (s != null && s <= nums[i].toLong() + t) {
                    return true
                }
                val g = set.floor(nums[i])
                if (g != null && nums[i] <= g.toLong() + t) {
                    return true
                }
                set.add(nums[i])
                if (set.size > k) {
                    set.remove(nums[i - k])
                }
            }
            return false
        }
    }
}