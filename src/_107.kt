class _107 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
        fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
            val ans = mutableListOf<MutableList<Int>>()
            dfs(root, 0, ans)
            ans.reverse()
            return ans
        }

        private fun dfs(root: TreeNode?, k: Int, ans: MutableList<MutableList<Int>>) {
            if (root == null) return
            if (k == ans.size) ans.add(mutableListOf())
            ans[k].add(root.`val`)
            dfs(root.left, k + 1, ans)
            dfs(root.right, k + 1, ans)
        }
    }
}