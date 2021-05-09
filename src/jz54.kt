import java.util.*

class jz54 {
    companion object {
        fun kthLargest(root: TreeNode?, k: Int): Int {
            if (root == null) return -1
            var idx = 0
            val stack = Stack<TreeNode>()
            var preRoot: TreeNode? = root
            while (stack.isNotEmpty() || preRoot != null) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }
                val node = stack.pop()
                if (++idx == k) {
                    return node.`val`
                }
                preRoot = node.right
            }
            return -1
        }

    }
}