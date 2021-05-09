import java.util.*

class jz06 {
    companion object{
        fun reversePrint(head: ListNode?): IntArray {
            val ans = LinkedList<Int>()
            var root = head
            while (root != null) {
                ans.add(0,root.`val`)
                root = root.next

            }
            return ans.toIntArray()
        }
    }
}