import java.util.*

class _2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                addTwoNumbers(
                    intArrayOf(2, 4, 3).toListNode(),
                    intArrayOf(5, 6, 4).toListNode()
                ).toIntArray().joinToString()
            )
        }

        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            val dummy = ListNode(0)
            var head: ListNode = dummy
            var curry = 0
            var root1: ListNode? = l1
            var root2: ListNode? = l2
            while (root1 != null || root2 != null || curry != 0) {
                val a = root1?.`val` ?: 0
                val b = root2?.`val` ?: 0
                val v = a + b + curry
                head.next = ListNode(v % 10)
                head = head.next!!
                curry = v / 10
                root1 = root1?.next
                root2 = root2?.next
            }
            return dummy.next
        }
    }
}