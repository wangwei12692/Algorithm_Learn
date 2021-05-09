class _jz24 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverseList2(intArrayOf(1, 2, 3, 4, 5).toListNode()).toIntArray().joinToString())
        }

        fun reverseList2(head: ListNode?): ListNode? {
            //1 2 3 4 5
            // 2 1
            var pre: ListNode? = null
            var root = head
            while (root != null) {
                val next = root.next
                root.next = pre
                pre = root
                root = next
            }
            return pre
        }

        fun reverseList(head: ListNode?): ListNode? {
            if (head?.next == null)
                return head
            //1
            // 5 4 3 2
            val cur = head
            val next = head.next
            val reversed = reverseList(next)
            next?.next = cur
            cur.next = null
            return reversed
        }
    }
}