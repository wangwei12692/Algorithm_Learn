import kotlin.math.abs

class `jz55-2` {
    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root) != -1
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        val left = dfs(root.left)
        val right = dfs(root.right)
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1
        }
        return Math.max(left, right) + 1
    }
}