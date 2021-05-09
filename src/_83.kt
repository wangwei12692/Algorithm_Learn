class _83 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(deleteDuplicates(intArrayOf(1,1,3).toListNode()).toIntArray().joinToString())
        }

        fun deleteDuplicates(head: ListNode?): ListNode? {
            if (head?.next == null) return head
            if (head.`val` == head.next!!.`val`){
                return deleteDuplicates(head.next)
            }
            head.next = deleteDuplicates(head.next)
            return head
        }
    }
}