class _25 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverseKGroup(intArrayOf(1, 2, 3, 4, 5).toListNode(), 2).toIntArray().joinToString())
        }

        fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
            val dummy = ListNode(-1)
            var tmpHead = head
            var lastTail: ListNode = dummy
            while (true) {
                var n = k - 1
                var tmpTail: ListNode? = tmpHead
                while (n > 0 && tmpTail != null) {
                    tmpTail = tmpTail.next
                    n--
                }
                if (n > 0) {
                    break
                }
                val root = tmpHead
                tmpHead = tmpTail?.next
                tmpTail?.next = null
                val reversed = reverse(root!!)
                lastTail.next = reversed
                lastTail = root
            }
            return dummy.next
        }

        private fun reverse(head: ListNode): ListNode {
            var pre: ListNode? = null
            var node: ListNode? = head
            while (node != null) {
                val next = node.next
                node.next = pre
                pre = node
                node = next
            }
            return pre!!
        }
    }
}