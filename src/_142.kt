class _142 {
    companion object {
        fun detectCycle(head: ListNode?): ListNode? {
            var fast = head
            var slow = head
            while (slow != null) {
                slow = slow.next
                fast = fast?.next?.next
                if (slow == fast && slow != null) {
                    var ptr = head
                    while (ptr != slow) {
                        ptr = ptr?.next
                        slow = slow?.next
                    }
                    return ptr
                }
            }
            return null
        }
    }
}