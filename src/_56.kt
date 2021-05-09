class _56 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val out = merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))
            println(out.joinToString())
        }

        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            if (intervals.size <= 1)
                return intervals
            intervals.sortBy { it[0] }
            val ans = mutableListOf<IntArray>()
            var (plh, prh) = intervals[0]
            for (i in 1 until intervals.size) {
                val (lh, rh) = intervals[i]
                if (lh in plh..prh) {
                    plh = Math.min(lh, plh)
                    prh = Math.max(rh, prh)
                } else {
                    ans.add(intArrayOf(plh, prh))
                    plh = lh
                    prh = rh
                }

            }
            ans.add(intArrayOf(plh, prh))
            return ans.toTypedArray()
        }
    }
}