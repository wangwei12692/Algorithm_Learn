class _1290 {
    companion object {
        fun getDecimalValue(head: ListNode?): Int {
            var ans = 0
            var root = head
            while (root != null) {
                ans = ans * 2 + root.`val`
                root = root.next
            }
            return ans
        }
    }
}