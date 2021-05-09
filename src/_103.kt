import java.util.*

class _103 {
    companion object {
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null)
                return emptyList()
            val ans = mutableListOf<MutableList<Int>>()
            dfs(root, 0, ans)
            return ans
        }

        private fun dfs(root: TreeNode?, k: Int, ans: MutableList<MutableList<Int>>) {
            if (root == null) return
            if (ans.size <= k) {
                ans.add(LinkedList<Int>())
            }
            if (k % 2 == 0) {
                ans[k].add(root.`val`)
            } else {
                ans[k].add(0, root.`val`)
            }
            dfs(root.left, k + 1, ans)
            dfs(root.right, k + 1, ans)
        }
    }
}