class _235 {
    companion object {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if (root == null || p == null || q == null) return null
            if (p.`val` < root.`val` && q.`val` < root.`val`)
                return lowestCommonAncestor(root.left, p, q)
            if (p.`val` > root.`val` && q.`val` > root.`val`)
                return lowestCommonAncestor(root.right, p, q)
            return root
        }
    }
}