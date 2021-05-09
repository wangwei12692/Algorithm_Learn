class  ms1710 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun majorityElement(nums: IntArray): Int {
            var idx = 0
            var target = nums[0]
            for (i in nums.indices) {
                if (nums[i] == target) {
                    idx++
                } else {
                    idx--
                }
                if (idx == 0) {
                    target = nums[i + 1]
                }
            }
            return if (nums.count { it == target } > nums.size / 2)
                target
            else
                -1
        }
    }
}