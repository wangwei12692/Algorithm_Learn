class ms0201 {
    companion object {
        fun removeDuplicateNodes(head: ListNode?): ListNode? {
            val seen = mutableSetOf<Int>()
            return removeDuplicate(head, seen)
        }

        private fun removeDuplicate(head: ListNode?, seen: MutableSet<Int>): ListNode? {
            if (head == null)
                return head
            if (seen.contains(head.`val`))
                return removeDuplicate(head.next,seen)
            seen.add(head.`val`)
            head.next = removeDuplicate(head.next,seen)
            return head
        }
    }
}