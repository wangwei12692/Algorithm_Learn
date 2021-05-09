class jz22 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(getKthFromEnd(intArrayOf(1, 2, 3, 4, 5).toListNode(), 2).toIntArray().joinToString())
        }

        fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
            var slow = head
            var fast = head
            var i = k
            while (i > 0) {
                fast = fast?.next
                i--
            }
            while (fast != null) {
                fast = fast.next
                slow = slow?.next
            }
            return slow
        }
    }
}