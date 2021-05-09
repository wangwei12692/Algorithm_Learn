import kotlin.math.max
import kotlin.math.min

class _164 {
    companion object {
        fun maximumGap(nums: IntArray): Int {
            if (nums.size < 2)
                return 0
            val n = nums.size
            val minVal = nums.min()!!
            val maxVal = nums.max()!!
            val d = max(1, (maxVal - minVal) / (n - 1))
            val bucketSize = (maxVal - minVal) / d + 1
            val bucket = Array(bucketSize) { IntArray(2) { -1 } }
            for (i in 0 until n) {
                val idx = (nums[i] - minVal) / d
                if (bucket[idx][0] == -1) {
                    bucket[idx][1] = nums[i]
                    bucket[idx][0] = bucket[idx][1]
                } else {
                    bucket[idx][0] = min(bucket[idx][0],nums[i])
                    bucket[idx][1] = max(bucket[idx][1],nums[i])
                }
            }

            var ret = 0
            var prev = -1
            for (i in 0..bucketSize) {
                if (bucket[i][0] == -1)
                    continue
                if (prev != -1) {
                    ret = max(ret,bucket[i][0] - bucket[prev][1])
                }
                prev = i
            }
            return ret
        }
    }
}