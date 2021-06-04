
import java.util.*

class _99 {
    companion object {

        fun recoverTree2(root: TreeNode?): Unit {
            val list = mutableListOf<TreeNode>()
            dfs(root, list)
            var x: TreeNode? = null
            var y: TreeNode? = null

            for (i in 0 until list.size - 1) {
                if (list[i].`val` > list[i + 1].`val`) {
                    y = list[i + 1]
                    if (x == null) {
                        x = list[i]
                    }
                }
            }
            if (x != null && y != null) {
                val xv = x.`val`
                x.`val` = y.`val`
                y.`val` = xv
            }
        }


        private fun dfs(node: TreeNode?, list: MutableList<TreeNode>) {
            if (node == null) {
                return
            }
            dfs(node.left, list);
            list.add(node);
            dfs(node.right, list);
        }


        fun recoverTree(root: TreeNode?): Unit {
            if (root == null) return

            val stack = Stack<TreeNode>()
            var preRoot: TreeNode? = root
            var pre: TreeNode? = null
            var x: TreeNode? = null
            var y: TreeNode? = null

            while (stack.isNotEmpty() || preRoot != null) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }

                val visited = stack.pop()
                preRoot = visited.right
                if (pre != null && visited.`val` < pre.`val`) {
                    y = visited
                    if (x == null) {
                        x = pre
                    } else
                        break
                }
                pre = visited
            }
            if (x != null && y != null) {
                val xv = x.`val`
                x.`val` = y.`val`
                y.`val` = xv
            }

        }
    }
}