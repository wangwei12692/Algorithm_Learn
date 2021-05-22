import jdk.nashorn.api.tree.Tree
import java.util.*

class _173 {
    companion object {

    }

    class BSTIterator(val root: TreeNode?) {
        val iterator = buildSequence().iterator()

        fun next(): Int {
            return iterator.next()
        }

        fun hasNext(): Boolean {
            return iterator.hasNext()
        }

        fun buildSequence() = sequence<Int> {
            var preRoot: TreeNode? = root
            val stack = Stack<TreeNode>()
            while (stack.isNotEmpty() || preRoot != null) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }
                val node = stack.pop()
                yield(node.`val`)
                preRoot = node.right
            }
        }

    }

}