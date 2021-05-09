class _160 {
    companion object{
        fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
            var pa = headA
            var pb = headB

            while (pa != pb) {
                pa = if (pa == null)
                    headB
                else
                    pa.next

                pb = if (pb == null) {
                    pa
                } else {
                    pb.next
                }
            }
            return pa
        }
    }
}