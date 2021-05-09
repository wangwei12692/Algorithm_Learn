import sort.swap

class _80 {
    companion object {

        fun removeDuplicates(nums: IntArray): Int {
            var id = 0
            for (n in nums) {
                if (id < 2 || n != nums[id - 2]) {
                    nums[id++] = n
                }
            }
            return id
        }
    }
}