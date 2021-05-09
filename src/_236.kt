class _236 {
    companion object {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if (root == null) return null
            if (p == root || q == root) {
                return root
            }
            val left = lowestCommonAncestor(root.left, p, q)
            val right = lowestCommonAncestor(root.right, p, q)
            if (left != null && right != null) {
                return root
            }else if (root.left != null) {
                return left
            }else if (root.right != null) {
                return right
            }
            return null
        }
    }
}