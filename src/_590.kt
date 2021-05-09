import java.util.*

class _590 {
    companion object {
        fun postorder(root: Node?): List<Int> {
            val ans = mutableListOf<Int>()
            dfs(root, ans)
            return ans
        }

        private fun dfs(root: Node?, ans: MutableList<Int>) {
            if (root == null) return
            root.children?.forEach {
                dfs(it, ans)
            }
            ans.add(root.`val`)
        }

        fun postorder2(root: Node?): List<Int> {
            if (root == null) return emptyList()
            val ans = mutableListOf<Int>()
            val stack = Stack<Node>()
            stack.push(root)
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                ans.add(node.`val`)
                node.children?.forEach {
                    stack.push(it)
                }
            }
            return ans.reversed()
        }

    }
}