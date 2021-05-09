import java.util.*

class _230 {
    companion object {
        fun kthSmallest(root: TreeNode?, k: Int): Int {
            if (root == null) return -1
            val stack = Stack<TreeNode>()
            var preRoot: TreeNode? = root
            var i = 0
            while (stack.isNotEmpty() || preRoot != null) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }
                val node = stack.pop()
                if (++i == k) {
                    return node.`val`
                }
                preRoot = node.right
            }
            return -1
        }
    }
}