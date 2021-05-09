class _897 {
    private val dummpy = TreeNode(-1)
    private var pre: TreeNode = dummpy

    fun increasingBST(root: TreeNode?): TreeNode? {
        dfs(root)
        return dummpy.right
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root.left)
        root.left = null
        pre.right = root
        pre = root
        dfs(root.right)
    }
}