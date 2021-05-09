class _1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int,Int>()
        for ((i, v) in nums.withIndex()) {
            val pre = map[target - v]
            if (pre != null) {
                return intArrayOf(pre, i)
            } else {
                map[v] = i
            }
        }
        return intArrayOf()
    }
}