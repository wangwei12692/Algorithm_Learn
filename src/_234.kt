class _234 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(isPalindrome(intArrayOf(1, 2, 2, 1).toListNode()))
        }


        fun isPalindrome2(head: ListNode?): Boolean {
            var n1: Long = 0
            var n2: Long = 0
            var multi = 1
            var root = head
            while (root != null) {
                n1 = n1 * 10 + root.`val`
                n2 = multi * root.`val` + n2
                multi *= 10
                root = root.next
            }
            return n1 == n2
        }

        fun isPalindrome(head: ListNode?): Boolean {
            if (head == null)
                return true
            var fast: ListNode? = head
            var slow: ListNode? = head
            while (fast != null) {
                fast = fast.next?.next
                slow = slow?.next
            }

            var pre: ListNode? = null
            while (slow != null) {
                val next = slow.next
                slow.next = pre
                pre = slow
                slow = next
            }
            var root: ListNode? = head
            while (pre != null && root != null) {
                if (root.`val` != pre.`val`) {
                    return false
                }
                root = root.next
                pre = pre.next
            }
            return true
        }
    }
}