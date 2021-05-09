class _404 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(3, null, null)
            root.left = TreeNode(9, null, null)
            root.right = TreeNode(20, null, null)
            root.right!!.left = TreeNode(15, null, null)
            root.right!!.right = TreeNode(7, null, null)
            println(sumOfLeftLeaves(root))
        }

        fun sumOfLeftLeaves(root: TreeNode?): Int {
            if (root == null) return 0
            return dfs(root, null)
        }

        private fun dfs(root: TreeNode?, parent: TreeNode?): Int {
            if (root == null) return 0
            if (root.left == null && root.right == null)
                return if (parent!!.left == root) root.`val` else 0
            return dfs(root.left, root) + dfs(root.right, root)
        }
    }
}