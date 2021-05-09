class _82 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                deleteDuplicates(intArrayOf(1, 2,3, 3, 4, 4, 4, 5).toListNode()).toIntArray()
                    .joinToString()
            )
        }
        fun deleteDuplicates(head: ListNode?): ListNode? {
            if (head == null)
                return null
            var next: ListNode? = head.next
            var find = false
            while (next != null && next.`val` == head.`val`) {
                next = next.next
                find = true
            }
            if (find) {
                return deleteDuplicates(next)
            }
            head.next = deleteDuplicates(head.next)
            return head
        }
    }
}