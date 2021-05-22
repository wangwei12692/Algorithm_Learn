import java.util.*

class _958 {
    companion object {
        //第一个空节点之后不应该再出现非空节点
        fun isCompleteTree(root: TreeNode?): Boolean {
            if (root == null) return true
            val queue = LinkedList<TreeNode>()
            queue.offer(root)
            var isFinish = false
            while (queue.isNotEmpty()) {
                val t = queue.poll()
                if (t.left != null) {
                    if (isFinish) return false
                    queue.offer(t.left)
                } else {
                    isFinish = true
                }
                if (t.right != null) {
                    if (isFinish) return false
                    queue.offer(t.right)
                } else {
                    isFinish = true
                }
            }
            return true
        }
    }
}