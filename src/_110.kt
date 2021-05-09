import kotlin.math.abs
import kotlin.math.max

class _110 {
    companion object {
        fun isBalanced2(root: TreeNode?): Boolean {
            // -1 invalid >=0 height
            return dfs(root) >= 0
        }

        private fun dfs(root: TreeNode?): Int {
            if (root == null)
                return 0
            val left = dfs(root.left)
            val right = dfs(root.right)
            if (left == -1 || right == -1 || Math.abs(left - right) > 1)
                return -1
            return max(left, right) + 1
        }

        fun isBalanced(root: TreeNode?): Boolean {
            if (root == null)
                return true
            val left = depth(root.left)
            val right = depth(root.right)
            if (abs(left - right) > 1)
                return false
            return isBalanced(root.left) && isBalanced(root.right)
        }

        private fun depth(root: TreeNode?): Int {
            if (root == null) return 0
            return max(depth(root.left), depth(root.right)) + 1
        }
    }
}