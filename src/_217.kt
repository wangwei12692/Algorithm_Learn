class _217 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun containsDuplicate(nums: IntArray): Boolean {
            return nums.toSet().size != nums.size
        }
    }
}