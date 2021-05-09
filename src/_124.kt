class _124 {
    companion object {
        var maxSum = Int.MIN_VALUE
        fun maxPathSum(root: TreeNode?): Int {
            dfs(root)
            return maxSum
        }

        private fun dfs(root: TreeNode?): Int {
            if (root == null)
                return 0
            val left = Math.max(dfs(root.left), 0)
            val right = Math.max(dfs(root.right), 0)

            val sum = left + right + root.`val`
            maxSum = Math.max(sum, maxSum)
            return Math.max(left, right) + root.`val`
        }

    }
}