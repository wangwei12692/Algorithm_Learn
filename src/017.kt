class `017` {
    companion object {
        fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
            if (root == null)
                return emptyList()
            val ans = mutableListOf<MutableList<Int>>()
            dfs(root, 0, ans)
            ans.reverse()
            return ans
        }

        private fun dfs(root: TreeNode?, k: Int, ans: MutableList<MutableList<Int>>) {
            if (root == null)
                return
            if (ans.size <= k) {
                ans.add(mutableListOf())
            }
            ans[k].add(root.`val`)
            dfs(root.left, k + 1, ans)
            dfs(root.right, k + 1, ans)
        }
    }
}



