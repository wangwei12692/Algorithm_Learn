class _237 {
    companion object {
        fun deleteNode(node: ListNode?) {
            if (node == null) return

            var root: ListNode? = node
            var prev: ListNode? = null
            while (root?.next != null) {
                root.`val` = root.next!!.`val`
                prev = root
                root = root.next
            }
            prev?.next = null
        }
    }
}