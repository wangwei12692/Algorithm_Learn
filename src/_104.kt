class _104 {
    companion object {
        fun maxDepth(root: TreeNode?): Int {
            if (root == null)
                return 0
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
        }
    }
}