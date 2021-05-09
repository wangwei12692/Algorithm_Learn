import java.util.*
import kotlin.math.min

class _111 {
    companion object {

        private data class QueueNode(val node: TreeNode, val height: Int)

        fun minDepth2(root: TreeNode?): Int {
            if (root == null)
                return 0
            val q: Queue<QueueNode> = LinkedList()
            q.offer(QueueNode(root, 1))
            while (q.isNotEmpty()) {
                val (node, height) = q.poll()
                if (node.left == null && node.right == null)
                    return height
                if (node.left != null) {
                    q.offer(QueueNode(node.left!!, height + 1))
                }
                if (node.right != null) {
                    q.offer(QueueNode(node.right!!, height + 1))
                }
            }
            //unreachable
            return 0
        }

        fun minDepth(root: TreeNode?): Int {
            if (root == null)
                return 0
            if (root.left == null && root.right == null) {
                return 1
            }
            if (root.left == null) {
                return minDepth(root.right) + 1
            } else if (root.right == null)
                return minDepth(root.right) + 1
            return min(minDepth(root.left), minDepth(root.right)) + 1
        }
    }
}