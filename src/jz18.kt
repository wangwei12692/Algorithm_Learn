class jz18 {
    companion object {
        fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
            if (head == null) {
                return head
            }
            if (head.`val` == `val`) {
                return deleteNode(head.next, `val`)
            }
            head.next = deleteNode(head.next, `val`)
            return head
        }
    }
}