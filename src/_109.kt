class _109 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = sortedListToBST(intArrayOf(1, 2, 3, 4, 5).toListNode())
            println()
        }

        fun sortedListToBST(head: ListNode?): TreeNode? {
            val nums = head.toIntArray()
            return dfs(nums, 0, nums.size - 1)
        }

        private fun ListNode?.toIntArray(): IntArray {
            if (this == null) return intArrayOf()
            val list = mutableListOf<Int>()
            var tmp = this
            while (tmp != null) {
                list.add(tmp.`val`)
                tmp = tmp.next
            }
            return list.toIntArray()
        }


        private fun dfs(nums: IntArray, lo: Int, hi: Int): TreeNode? {
            if (lo > hi)
                return null
            val mid = (lo + hi) / 2
            val root = TreeNode(nums[mid])
            root.left = dfs(nums, lo, mid - 1)
            root.right = dfs(nums, mid + 1, hi)
            return root
        }
    }
}