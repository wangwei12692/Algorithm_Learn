import java.util.*
import kotlin.math.abs

class _1046 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
        }

        data class Stone(val weight: Int, var count: Int = 0)

        fun lastStoneWeight(stones: IntArray): Int {
            val pq = PriorityQueue<Int>(compareBy { -it })
            pq.addAll(stones.toList())
            while (pq.size > 1) {
                val a = pq.poll()
                val b = pq.poll()
                if (a > b) {
                    pq.offer(a - b)
                }
            }
            return if (pq.isEmpty()) 0 else pq.poll()
        }
    }
}