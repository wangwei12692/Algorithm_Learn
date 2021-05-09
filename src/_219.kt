class _219 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
        }

        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            val set = mutableSetOf<Int>()
            for (i in nums.indices) {
                if (set.contains(nums[i]))
                    return true
                set.add(nums[i])
                if (set.size > k) {
                    //删除最先进入的元素
                    set.remove(nums[i - k])
                }
            }
            return false
        }
    }
}