import java.util.*

class _253 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                minMeetingRooms(
                    arrayOf(
                        intArrayOf(7, 10),
                    )
                )
            )

            println(
                minMeetingRooms2(
                    arrayOf(
                        intArrayOf(7, 10),
                    )
                )
            )
        }

        fun minMeetingRooms2(intervals: Array<IntArray>): Int {
            val delta = TreeMap<Int, Int>()
            for ((start, end) in intervals) {
                delta[start] = delta.getOrDefault(start, 0) + 1
                delta[end] = delta.getOrDefault(end, 0) - 1
            }
            var active = 0
            var ans = 0
            for (d in delta.values) {
                active += d
                ans = Math.max(active, ans)
            }
            return ans
        }

        fun minMeetingRooms(intervals: Array<IntArray>): Int {
            intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
            val pq = PriorityQueue<Int>()
            pq.offer(intervals[0][1])
            for (i in 1 until intervals.size) {
                if (intervals[i][0] >= pq.peek()) {
                    pq.poll()
                }
                pq.offer(intervals[i][1])
            }
            return pq.size
        }
    }
}