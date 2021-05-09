class jz25 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                mergeTwoLists2(intArrayOf(1, 2, 4).toListNode(), intArrayOf(1, 3, 4).toListNode())
                    .toIntArray().joinToString()
            )
        }

        fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
            if (l1 == null && l2 == null) {
                return null
            }
            if (l1 == null) return l2
            if (l2 == null) return l1

            if (l1.`val` < l2.`val`) {
                l1.next = mergeTwoLists2(l1.next, l2)
                return l1
            }
            l2.next = mergeTwoLists2(l1, l2.next)
            return l2
        }

        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            var root1: ListNode? = l1
            var root2: ListNode? = l2
            val dummy = ListNode(-1)
            var head: ListNode? = dummy
            while (root1 != null || root2 != null) {
                if (root1 != null && root2 != null) {
                    if (root1.`val` < root2.`val`) {
                        head?.next = root1
                        root1= root1.next
                    } else {
                        head?.next = root2
                        root2= root2.next
                    }
                }else if (root1 != null) {
                    head?.next = root1
                    break
                }else if (root2 != null) {
                    head?.next = root2
                    break
                }
                head = head?.next
            }
            return dummy.next
        }
    }
}