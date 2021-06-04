
import java.util.*
import kotlin.math.min

class _530 {
    companion object {
        fun getMinimumDifference(root: TreeNode?): Int {
            var minDiff = 0
            val stack = Stack<TreeNode>()
            var preRoot: TreeNode? = root
            var pre = -1
            while (stack.isNotEmpty() || preRoot != null) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }
                val node = stack.pop()
                if (pre != -1) {
                    minDiff = Math.min(pre, node.`val`)
                    pre = node.`val`
                } else {
                    pre = node.`val`
                }
                preRoot = node.right
            }

            return minDiff
        }
    }
}