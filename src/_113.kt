class _113 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
            if (root == null)
                return emptyList()
            val ans = mutableListOf<List<Int>>()
            dfs(root, targetSum, mutableListOf<Int>(), ans)
            return ans
        }

        private fun dfs(root: TreeNode?, targetSum: Int, line: MutableList<Int>, ans: MutableList<List<Int>>) {
            if (root == null)
                return
            if (targetSum == root.`val` && root.left == null && root.right == null) {
                line.add(root.`val`)
                ans.add(line.toList())
                line.removeLast()
                return
            }
            line.add(root.`val`)
            dfs(root.left, targetSum - root.`val`, line, ans)
            dfs(root.right, targetSum - root.`val`, line, ans)
            line.removeLast()
        }
    }
}