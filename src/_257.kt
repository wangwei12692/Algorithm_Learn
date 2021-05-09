class _257 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val root = TreeNode(1, null, null)
            root.left = TreeNode(2, null, null)
            root.right = TreeNode(3, null, null)
            root.left!!.right = TreeNode(5, null, null)
            println(binaryTreePaths(root))
        }

        fun binaryTreePaths(root: TreeNode?): List<String> {
            if (root == null) return emptyList()
            val ans = mutableListOf<String>()
            dfs(root, ans, mutableListOf<Int>(root.`val`))
            return ans
        }

        private fun dfs(root: TreeNode?, ans: MutableList<String>, line: MutableList<Int>) {
            if (root == null) return
            if (root.left == null && root.right == null) {
                ans.add(line.joinToString("->"))
                return
            }
            if (root.left != null) {
                line.add(root.left!!.`val`)
                dfs(root.left, ans, line)
                line.removeLast()
            }
            if (root.right != null) {
                line.add(root.right!!.`val`)
                dfs(root.right, ans, line)
                line.removeLast()
            }
        }
    }
}