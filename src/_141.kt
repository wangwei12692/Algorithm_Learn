class _141 {
    companion object {

        fun hasCycle(head: ListNode?): Boolean {
            var fast: ListNode? = head
            var slow: ListNode? = head
            while (slow != null) {
                fast = fast?.next?.next
                slow = slow.next
                if (slow == fast && slow != null)
                    return true
            }
            return false
        }
    }
}