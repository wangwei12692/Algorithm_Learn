class _21 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                mergeTwoLists(
                    intArrayOf().toListNode(),
                    intArrayOf().toListNode()
                ).toIntArray().joinToString()
            )
        }

        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val dummy = ListNode(0)
            var head: ListNode? = dummy
            var root1: ListNode? = l1
            var root2: ListNode? = l2
            while (root1 != null || root2 != null) {
                if (root1 == null) {
                    head?.next = root2
                    break
                } else if (root2 == null) {
                    head?.next = root1
                    break
                } else {
                    if (root1.`val` < root2.`val`) {
                        head?.next = root1
                        root1 = root1.next
                        head = head?.next
                    } else {
                        head?.next = root2
                        root2 = root2.next
                        head = head?.next
                    }
                }
            }
            return dummy.next
        }
    }
}