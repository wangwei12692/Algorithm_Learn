import java.util.ArrayList

class _148 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val head = intArrayOf(4, 2, 1, 3).toListNode()
            val ans = sortList(head)
            println(ans.toIntArray().joinToString())
        }

        fun sortList(head: ListNode?): ListNode? {
            val list = arrayListOf<ListNode>()
            var root = head
            while (root != null) {
                list.add(root)
                root = root.next
            }
            list.sortBy { it.`val` }
            val dummy = ListNode(-1)
            var newHead = dummy
            for (next in list) {
                newHead.next = next
                newHead = next
                next.next = null
            }
            return dummy.next
        }

        private fun sort(list: ArrayList<ListNode>, lo: Int, hi: Int) {
            if (lo == hi)
                return
            val mid = lo + (hi - lo) / 2
            sort(list, lo, mid)
            sort(list, mid + 1, hi)

        }

    }

}