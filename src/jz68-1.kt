class `jz68-1` {
    companion object {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
            if (root == null) return null
            if (p.`val` < root.`val` && q.`val` < root.`val`) {
                return lowestCommonAncestor(root.left, p, q)
            }else if (p.`val` > root.`val` && q.`val` > root.`val`) {
                return lowestCommonAncestor(root.right, p, q)
            }
            return root
        }
    }
}