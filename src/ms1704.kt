class ms1704 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun missingNumber(nums: IntArray): Int {
            val n = nums.size
            return (1+n)*n/2 - nums.sum()
        }

    }
}