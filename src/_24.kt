class _24 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(swapPairs(
                intArrayOf(1).toListNode()
            ).toIntArray().joinToString())
        }

        fun swapPairs(head: ListNode?): ListNode? {
            val dummy = ListNode(-1)
            var newHead: ListNode? = dummy
            var root: ListNode? = head
            while (root?.next != null) {
                val prev = root
                val next = root.next
                root = next?.next

                newHead?.next = next
                next?.next = prev
                newHead = prev
                prev.next = null
            }
            if (root != null) {
                newHead?.next = root
            }
            return dummy.next
        }
    }
}