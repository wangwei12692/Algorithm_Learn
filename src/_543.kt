class _543 {
    private var dima = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return dima
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        val left = dfs(root.left)
        val right = dfs(root.left)
        dima = Math.max(left + right + 1, dima)
        return Math.max(left, right) + 1
    }
}