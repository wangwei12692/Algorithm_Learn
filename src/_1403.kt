class _1403 {
    companion object {
        fun minSubsequence(nums: IntArray): List<Int> {
            nums.sort()
            val sum = nums.sum()
            val ans = mutableListOf<Int>()
            var total = 0
            for (i in nums.size - 1 downTo 0) {
                total += nums[i]
                ans.add(nums[i])
                if (total > sum / 2) {
                    break
                }
            }
            return ans
        }
    }
}