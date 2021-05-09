class ms1712 {
    private val dummy: TreeNode = TreeNode(-1)
    private var pre = dummy
    fun convertBiNode(root: TreeNode?): TreeNode? {
        if (root == null) return null
        dfs(root)
        return dummy.right
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root.left)
        pre.right = root
        pre = root
        root.left = null
        dfs(root.right)
    }
}