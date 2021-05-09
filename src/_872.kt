class _872 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
        fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
            if (root1 == root2) return true
            if (root1 == null || root2 == null) return false
            val left = mutableListOf<Int>()
            val right = mutableListOf<Int>()
            dfs(root1, left)
            dfs(root1, right)
            return left == right
        }

        private fun dfs(root: TreeNode?, ans: MutableList<Int>) {
            if (root == null) return
            if (root.left == null && root.right == null) {
                ans.add(root.`val`)
                return
            }
            dfs(root.left, ans)
            dfs(root.right, ans)
        }
    }
}