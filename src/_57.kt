import java.util.*
import kotlin.math.max
import kotlin.math.min

class _57 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val res = insert(arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 5),
                intArrayOf(6, 7),
                intArrayOf(8, 10),
                intArrayOf(12, 16),
            ), intArrayOf(4, 8))
            println(res.joinToString { it.contentToString() })
        }

        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val ans = mutableListOf<IntArray>()
            val pq = PriorityQueue<IntArray>(compareBy { it[0] })
            pq.addAll(intervals)
            pq.add(newInterval)

            while (pq.size > 1) {
                val r1 = pq.poll()
                val r2 = pq.poll()
                val (lo1, hi1) = r1
                val (lo2, hi2) = r2
                if (hi1 < lo2) {
                    ans.add(r1)
                    pq.offer(r2)
                } else {
                    pq.offer(intArrayOf(min(lo1, lo2), max(hi1, hi2)))
                }
            }
            if (pq.isNotEmpty()) {
                ans.add(pq.poll())
            }
            return ans.toTypedArray()
        }
    }
}