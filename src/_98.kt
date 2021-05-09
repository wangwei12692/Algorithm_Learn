import java.util.*

class _98 {
    companion object{
        fun isValidBST(root: TreeNode?): Boolean {
            if (root == null)
                return true
            return dfs(root, Int.MIN_VALUE, Int.MAX_VALUE)
        }

        private fun dfs(root: TreeNode?, minValue: Int, maxValue: Int): Boolean {
            if (root == null) return true
            if (root.`val` <= minValue || root.`val` >= maxValue)
                return false
            return dfs(root.left, minValue, root.`val`) && dfs(root.right, root.`val`, maxValue)
        }

        //中序遍历
        fun isValidBST2(root: TreeNode?): Boolean {
            if (root == null)
                return true
            val stack = Stack<TreeNode>()
            var preRoot = root
            var last = Int.MIN_VALUE
            while (preRoot != null || stack.isNotEmpty()) {
                while (preRoot != null) {
                    stack.push(preRoot)
                    preRoot = preRoot.left
                }

                val node = stack.pop()
                if (node.`val` <= last) {
                    return false
                }
                last = node.`val`
                preRoot = node.right
            }
            return true
        }
    }

}