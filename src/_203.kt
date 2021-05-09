class _203 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null)
            return head
        if (head.`val` == `val`)
            return removeElements(head.next, `val`)
        head.next = removeElements(head.next, `val`)
        return head
    }
}