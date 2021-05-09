class jz52 {
    companion object{
        fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
            var p = headA
            var q = headB
            while (p !== q) {
                p = if (p != null) p.next else headB
                q = if (q != null) q.next else headA
            }
            return p
        }
    }
}