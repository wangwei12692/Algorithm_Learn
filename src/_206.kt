class _206 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverseList2(intArrayOf(1, 2, 3, 4, 5).toListNode()).toIntArray().joinToString())
        }

        fun reverseList(head: ListNode?): ListNode? {
            if (head == null)
                return null
            var root: ListNode? = head
            var pre: ListNode? = null
            while (root != null) {
                val next = root.next
                root.next = pre
                pre = root
                root = next
            }
            return pre
        }

        fun reverseList2(head: ListNode?): ListNode? {
            // 1 2 3 4 5
            if (head?.next == null)
                return head
            //1
            val cur = head
            //5 4 3 2
            val next = cur.next
            val reversed = reverseList2(next)
            next?.next = cur
            cur.next = null
            return reversed
        }
    }
}