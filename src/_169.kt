class _169 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun majorityElement(nums: IntArray): Int {
            nums.sort()
            return nums[nums.size / 2]
        }
    }
}