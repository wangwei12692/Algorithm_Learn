class _86 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(partition(intArrayOf(2,1).toListNode(), 2).toIntArray().joinToString())
        }

        fun partition(head: ListNode?, x: Int): ListNode? {
            if (head?.next == null) return head
            val node = partition(head.next, x)!!
            if (node.`val` < x && head.`val` >= x) {
                var next: ListNode? = node
                while (next?.next != null && next.next!!.`val` < x) {
                    next = next.next
                }
                val n = next?.next
                next?.next = head
                head.next = n
                return node
            }
            head.next = node
            return head
        }
    }
}