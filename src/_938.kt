class _938 {
    companion object {
        fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
            if (root == null) return 0
            if (root.`val` < low)
                return rangeSumBST(root.right, low, high)
            if (root.`val` > high)
                return rangeSumBST(root.left, low, high)
            return root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
        }
    }
}