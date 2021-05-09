class _108 {
    companion object {
        fun sortedArrayToBST(nums: IntArray): TreeNode? {
            if (nums.isEmpty()) return null
            return dfs(nums, 0, nums.size - 1)
        }

        private fun dfs(nums: IntArray, lo: Int, hi: Int): TreeNode? {
            if (lo > hi) return null
            val mid = lo + (hi - lo) / 2
            val node = TreeNode(nums[mid], null, null)
            node.left = dfs(nums, lo, mid - 1)
            node.right = dfs(nums, mid + 1, hi)
            return node
        }
    }
}