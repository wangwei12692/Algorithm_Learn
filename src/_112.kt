class _112 {
    companion object {
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            if (root == null) {
                return false
            }
            if (targetSum < 0) {
                return false
            }
            if (root.left == null && root.right == null)
                return targetSum == root.`val`

            return hasPathSum(root.left, targetSum - root.`val`) ||
                    hasPathSum(root.right, targetSum - root.`val`)

        }
    }
}