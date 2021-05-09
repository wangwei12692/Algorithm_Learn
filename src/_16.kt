class _16 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                threeSumClosest(intArrayOf(-1, 2, 1, -4), 2)
            )
        }

        fun threeSumClosest(nums: IntArray, target: Int): Int {
            if (nums.size < 3)
                return -1
            nums.sort()
            var ans = nums[0] + nums[1] + nums[2]
            for ((i, v) in nums.withIndex()) {
                var lo = i + 1
                var hi = nums.size - 1
                while (lo < hi) {
                    val t = v + nums[lo] + nums[hi]
                    val cmp =  t - target
                    when {
                        cmp == 0 -> {
                            return target
                        }
                        cmp < 0 -> {
                            while (lo < hi && nums[lo] == nums[lo + 1]) {
                                lo++
                            }
                            lo++
                        }
                        else -> {
                            while (lo < hi && nums[hi] == nums[hi-1]) {
                                hi--
                            }
                            hi--
                        }
                    }
                    ans = if (Math.abs(ans) -  target > Math.abs(cmp) - target) t else ans
                }
            }
            return ans
        }
    }
}