import kotlin.math.max
import kotlin.math.min

class _4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
            val m = nums1.size
            val n = nums2.size
            if (m > n) {
                return findMedianSortedArrays2(nums2, nums1)
            }
            var lo = 0
            var hi = m
            val len = (m + n + 1) / 2
            var leftMax = Int.MIN_VALUE
            var rightMin = Int.MAX_VALUE
            while (lo <= hi) {
                val c1 = (lo + hi) / 2
                val c2 = len - c1
                val n1leftMax = if (c1 == 0) Int.MIN_VALUE else nums1[c1 - 1]
                val n1rightMin = if (c1 == m) Int.MAX_VALUE else nums1[c1]
                val n2leftMax = if (c2 == 0) Int.MIN_VALUE else nums2[c2 - 1]
                val n2rightMIn = if (c2 == n) Int.MAX_VALUE else nums2[c2]
                if (n1leftMax <= n2rightMIn && n2leftMax <= n1rightMin) {
                    leftMax = max(n1leftMax, n2leftMax)
                    rightMin = min(n1rightMin, n2rightMIn)
                    break
                } else if (n1leftMax > n2rightMIn) {
                    hi = c1 - 1
                } else {
                    lo = c1 + 1
                }
            }
            return if ((m + n) % 2 == 0) (leftMax + rightMin) / 2.0 else leftMax.toDouble()
        }

        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val len = nums1.size + nums2.size
            val merged = IntArray(len)
            var m = 0
            var n = 0
            for (i in 0..len / 2) {
                if (m >= nums1.size) {
                    merged[i] = nums2[n++]
                } else if (n >= nums2.size) {
                    merged[i] = nums1[m++]
                } else if (nums1[m] < nums2[n]) {
                    merged[i] = nums1[m++]
                } else {
                    merged[i] = nums2[n++]
                }
            }

            return if (len % 2 != 0) merged[len / 2].toDouble() else (merged[len / 2 - 1] + merged[len / 2]) / 2.0
        }
    }

}