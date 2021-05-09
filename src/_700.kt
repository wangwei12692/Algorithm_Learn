class _700 {
    companion object {
        fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
            if (root == null)
                return null
            if (root.`val` == `val`) {
                return root
            } else if (root.`val` < `val`) {
                return searchBST(root.right, `val`)
            }
            return searchBST(root.left, `val`)
        }
    }
}