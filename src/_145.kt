import java.util.*

class _145 {
    companion object {
        fun postorderTraversal2(root: TreeNode?): List<Int> {
            if (root == null)
                return emptyList()
            val ans = mutableListOf<Int>()
            val stack = Stack<TreeNode>()
            var preRoot = root
            var lastVisited: TreeNode? = null
            while (stack.isNotEmpty() || preRoot != null) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }
                val node = stack.peek()
                if (node.right == null || node.right == lastVisited/*右子树已遍历完*/) {
                    ans.add(node.`val`)
                    stack.pop()
                    lastVisited = node //遍历完的节点
                    preRoot =null
                } else {
                    preRoot = node.right
                }
            }
            return ans
        }

        fun postorderTraversal(root: TreeNode?): List<Int> {
            val ans = mutableListOf<Int>()
            dfs(root, ans)
            return ans
        }

        private fun dfs(root: TreeNode?, ans: MutableList<Int>) {
            if (root == null)
                return
            dfs(root.left, ans)
            dfs(root.right, ans)
            ans.add(root.`val`)
        }


    }
}