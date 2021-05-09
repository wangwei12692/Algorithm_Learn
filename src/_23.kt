import java.util.*

class _23 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun mergeKLists2(lists: Array<ListNode?>): ListNode? {
            val k = lists.size
            val dummy = ListNode(-1)
            var head: ListNode? = dummy
            val pq = PriorityQueue<ListNode>(compareBy { it.`val` })
            while (true) {
                for (i in 0 until k) {
                    val cur = lists[i]
                    if (cur != null) {
                        pq.offer(cur)
                        lists[i] = cur.next
                    }
                    if (pq.isEmpty())
                        return dummy.next
                    head!!.next = pq.poll()
                    head = head!!.next
                }
            }
        }

        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            val pq = PriorityQueue<ListNode>(compareBy { it.`val` })
            val dummy = ListNode(-1)
            var head = dummy
            for (node in lists) {
                var root: ListNode? = node
                while (root != null) {
                    pq.offer(root)
                    root = root.next
                }
            }
            while (pq.isNotEmpty()) {
                val node = pq.poll()
                head.next = node
                head = node
            }
            head.next = null
            return dummy.next
        }
    }
}