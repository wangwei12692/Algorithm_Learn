import kotlin.math.abs

class _563 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(3)
            println(findTilt(root))
        }

        private var sum = 0
        fun findTilt(root: TreeNode?): Int {
            dfs(root)
            return sum
        }

        private fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val left = dfs(root.left)
            val right = dfs(root.right)
            sum += (abs(left - right))
            return left + right + root.`val`
        }
    }

}