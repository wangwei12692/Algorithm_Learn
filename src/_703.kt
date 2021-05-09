import java.util.*

class _703 {

    class KthLargest(val k: Int, nums: IntArray) {
        private val pq = PriorityQueue<Int>()

        init {
            pq.addAll(nums.toList())
        }

        fun add(`val`: Int): Int {
            pq.offer(`val`)
            if (pq.size > k)
                pq.poll()
            return pq.peek()
        }
    }
}