class _61 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(rotateRight(intArrayOf(0,1,2).toListNode(), 4).toIntArray().joinToString())
        }
        fun rotateRight(head: ListNode?, k: Int): ListNode? {
            var root1: ListNode? = head
            var i = 0
            while (i <= k) {
                if (root1 == null)
                    root1 = head
                root1 = root1?.next
                i++
            }
            var root2: ListNode? = head
            while (root1 != null) {
                root1 =root1.next
                root2 =root2?.next
            }

            val newHead = root2?.next
            val tail = root2
            while (root2?.next != null) {
                root2 = root2.next
            }
            root2?.next = head
            tail?.next = null
            return newHead
        }
    }
}