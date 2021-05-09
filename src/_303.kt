class _303 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val num = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
            println(num.sumRange(0, 2))
            println(num.sumRange(2, 5))
        }
    }

    class NumArray(val nums: IntArray) {
        val acc = IntArray(nums.size)

        init {
            acc[0] = nums[0]
            for (i in 1 until nums.size) {
                acc[i] = acc[i - 1] + nums[i]
            }
        }

        fun sumRange(left: Int, right: Int): Int {
            return acc[right] - if (left - 1 >= 0) acc[left - 1] else 0
        }
    }


}