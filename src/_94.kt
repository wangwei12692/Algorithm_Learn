import java.util.*

class _94 {
    companion object {
        fun inorderTraversal(root: TreeNode?): List<Int> {
            if (root == null)
                return emptyList()
            val ans = mutableListOf<Int>()
            dfs(root, ans)
            return ans
        }

        private fun dfs(root: TreeNode?, ans: MutableList<Int>) {
            if (root == null)
                return
            dfs(root.left, ans)
            ans.add(root.`val`)
            dfs(root.right, ans)
        }

        fun inorderTraversal2(root: TreeNode?): List<Int> {
            val ans = mutableListOf<Int>()
            val stack = Stack<TreeNode>()
            var preRoot = root
            while (preRoot != null || stack.isNotEmpty()) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }
                val node = stack.pop()
                ans.add(node.`val`)
                preRoot = node.right
            }
            return ans
        }


    }
}