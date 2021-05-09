class jz03 {
    companion object{
        fun findRepeatNumber(nums: IntArray): Int {
            val arr = IntArray(nums.size)
            for (i in arr.indices) {
                if (arr[nums[i]] == 1) {
                    return nums[i]
                }
                arr[nums[i]]++
            }
            return -1
        }
    }
}