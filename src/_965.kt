class _965 {
    companion object {
        fun isUnivalTree(root: TreeNode?): Boolean {
            if (root == null) return true
            return dfs(root, root.`val`)
        }

        private fun dfs(root: TreeNode?, target: Int): Boolean {
            if (root == null) return true
            if (root.`val` != target) return false
            return dfs(root.left, target) && dfs(root.right, target)
        }
    }
}