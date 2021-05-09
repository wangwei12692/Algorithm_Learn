class jz39 {
    companion object{
        fun majorityElement(nums: IntArray): Int {
            var last = nums[0]
            var i = 0
            for (n in nums) {
                if (n == last)
                    i++
                else
                    i--
                if (i == 0) {
                    last = n
                    i++
                }
            }
            return last
        }

        @JvmStatic
        fun main(args: Array<String>) {
            println(majorityElement(intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)))
        }
    }
}