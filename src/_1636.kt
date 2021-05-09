class _1636 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(frequencySort(intArrayOf(1, 1, 2, 2, 2, 3)).joinToString())
        }

        fun frequencySort(nums: IntArray): IntArray {
            val map = mutableMapOf<Int, Int>()
            for (num in nums) {
                map.put(num, map.getOrDefault(num, 0) + 1)
            }
            return nums.sortedBy { map[it] }.toIntArray()
        }
    }
}