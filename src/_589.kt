import java.util.*

class _589 {
    companion object{
        fun preorder(root: Node?): List<Int> {
            if (root == null) return emptyList()
            val ans  = mutableListOf<Int>()
            val stack = Stack<Node>()
            stack.push(root)
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                ans.add(node.`val`)
                node.children?.reversed()?.forEach {
                    stack.push(it)
                }
            }
            return ans
        }
    }

}