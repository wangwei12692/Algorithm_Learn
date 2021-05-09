class _1481 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(findLeastNumOfUniqueInts(intArrayOf(4,3,1,1,3,3,2), 3))
        }

        fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
            val map = mutableMapOf<Int, Int>()
            for (v in arr) {
                val cnt = map.get(v)
                if (cnt == null) {
                    map[v] = 1
                } else {
                    map[v] = cnt + 1
                }
            }
            val total = map.size
            val entries = map.entries.sortedBy { it.value }
            var cnt = k
            var removed = 0
            for ((v, n) in entries) {
                if (cnt - n >= 0) {
                    cnt -= n
                    removed++
                } else {
                    break
                }
            }
            return total - removed
        }
    }
}