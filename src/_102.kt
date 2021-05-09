import java.util.*

class _102 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun levelOrder2(root: TreeNode?): List<List<Int>> {
            if (root == null)
                return emptyList()
            val ans = mutableListOf<List<Int>>()
            val q :Queue<TreeNode> = LinkedList<TreeNode>()
            val line = mutableListOf<Int>()
            q.offer(root)
            while (q.isNotEmpty()) {
                val size = q.size
                for (i in 0 until size) {
                    val node = q.poll()
                    line.add(node.`val`)
                    if (node.left!=null)
                        q.offer(node.left)
                    if (node.right!=null)
                        q.offer(node.right)
                }
                ans.add(line.toList())
                line.clear()
            }
            return ans
        }

        fun levelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return emptyList()
            val ans = mutableListOf<MutableList<Int>>()
            dfs(root, 0, ans)
            return ans
        }

        private fun dfs(root: TreeNode?, k: Int, ans: MutableList<MutableList<Int>>) {
            if (root == null)
                return
            if (ans.size <= k) {
                ans.add(mutableListOf())
            }
            ans[k].add(root.`val`)
            dfs(root.left, k + 1, ans)
            dfs(root.right, k + 1, ans)
        }
    }
}