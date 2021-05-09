class _92 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
            var lh: ListNode? = null
            var lhPre: ListNode? = null
            var rh: ListNode? = null
            var root: ListNode? = head
            var lo = left
            var hi = right
            while (root != null) {
                if (--lo == 0) {
                    lh = root
                }
                if (--hi == 0) {
                    rh = root
                    break
                }
                if (lh == null) {
                    lhPre = root
                }
                root = root.next
            }
            if (lh == rh)
                return head
            val next = rh?.next
            rh?.next = null

            val revTail = lh
            var pre: ListNode? = null
            while (lh != null) {
                val node = lh.next
                lh.next = pre
                pre = lh
                lh = node
            }
            revTail?.next = next
            if (lhPre == null) {
                return pre
            } else {
                lhPre.next = pre
            }
            return head
        }
    }
}