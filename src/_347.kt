class _347 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(topKFrequent(intArrayOf(1), 1).joinToString())
        }
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val map = mutableMapOf<Int, Int>()
            for (n in nums) {
                map[n] = map.getOrDefault(n, 0) + 1
            }
            val freq = map.entries.sortedBy { -it.value }
            return freq.subList(0,k).map { it.key }.toIntArray()
        }
    }
}