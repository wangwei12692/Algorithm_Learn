class _199 {
    companion object {
        fun rightSideView(root: TreeNode?): List<Int> {
            if (root == null)
                return emptyList()
            val ans = mutableListOf<Int>()
            dfs(root, 0, ans)
            return ans
        }

        private fun dfs(root: TreeNode?, k: Int, ans: MutableList<Int>) {
            if (root == null)
                return
            if (ans.size == k) {
                ans.add(root.`val`)
            }
            dfs(root.right, k + 1, ans)
            dfs(root.left, k + 1, ans)
        }
    }
}