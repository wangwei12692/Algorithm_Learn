class _167 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(twoSum(intArrayOf(2,3,4), 6).joinToString())
        }

        fun twoSum(numbers: IntArray, target: Int): IntArray {
            val map = hashMapOf<Int, Int>()
            for ((i, v) in numbers.withIndex()) {
                if (map.contains(target - v)) {
                    return intArrayOf(map[target - v]!! + 1, i + 1)
                } else {
                    map[v] = i
                }
            }
            return intArrayOf()
        }
    }
}