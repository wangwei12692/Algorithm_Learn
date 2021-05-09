class _101 {
    companion object {
        fun isSymmetric(root: TreeNode?): Boolean {
            if (root == null) return true
            return dfs(root.left, root.right)
        }

        private fun dfs(left: TreeNode?, right: TreeNode?): Boolean {
            if (left == null && right == null) {
                return true
            }
            if (left == null || right == null)
                return false
            if (left.`val` != right.`val`)
                return false
            return dfs(left.left, right.right) && dfs(left.right, right.left)
        }
    }
}