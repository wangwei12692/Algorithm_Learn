class _876 {
    companion object {
        fun middleNode(head: ListNode?): ListNode? {
            var slow: ListNode? = head
            var fast: ListNode? = head
            while (fast != null) {
                fast = fast.next?.next
                slow = slow?.next
            }
            return slow
        }
    }
}