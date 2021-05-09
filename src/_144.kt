import java.util.*

class _144 {
    companion object {
        fun preorderTraversal(root: TreeNode?): List<Int> {
            val ans = mutableListOf<Int>()
            dfs(root, ans)
            return ans
        }

        private fun dfs(root: TreeNode?, ans: MutableList<Int>) {
            if (root == null) return
            ans.add(root.`val`)
            dfs(root.left, ans)
            dfs(root.right, ans)
        }


        fun preorderTraversal2(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()

            val ans = mutableListOf<Int>()
            val stack = Stack<TreeNode>()
            var preRoot = root
            while (stack.isNotEmpty() || preRoot != null) {
                while (preRoot != null) {
                    ans.add(preRoot.`val`)
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }
                preRoot = stack.pop().right
            }
            return ans
        }

    }
}