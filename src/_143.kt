class _143 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val head = intArrayOf(1, 2, 3, 4, 5).toListNode()
            reorderList(head)
            println(head.toIntArray().joinToString())
        }
        fun reorderList(head: ListNode?): Unit {
            //find middle
            val slow = middle(head)
            var middle = slow?.next
            slow?.next = null
            //reverse
            var pre: ListNode? = null
            while (middle != null) {
                val next = middle.next
                middle.next = pre
                pre = middle
                middle = next
            }

            //merge  pre head
            var root: ListNode? = head
            while (pre != null && root != null) {
                val node = root?.next
                val pNext = pre?.next
                root?.next = pre
                pre?.next = node
                root = node
                pre = pNext
            }
        }

        private fun middle(head: ListNode?): ListNode? {
            var fast: ListNode? = head
            var slow: ListNode? = head
            while (fast?.next?.next != null) {
                fast = fast.next?.next
                slow = slow?.next
            }
            return slow
        }
    }
}