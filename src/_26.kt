class _26 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(removeDuplicates(intArrayOf(1, 1, 2)))
        }

        fun removeDuplicates(nums: IntArray): Int {
            var idx = 0
            var i = 0
            while (i < nums.size) {
                nums[idx++] = nums[i]
                while (i + 1 < nums.size && nums[i + 1] == nums[i]) {
                    i++
                }
                i++
            }
            return idx
        }
    }
}