class ms0207 {
    companion object{
        fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
            var h1 = headA
            var h2 = headB
            while (h1 !== h2) {
                h1 = if (h1 == null) headB else h1.next
                h2 = if (h2 == null) headA else h2.next
            }
            return h1
        }
    }
}