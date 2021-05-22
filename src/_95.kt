class _95 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val ans = generateTrees(3)
            println()
        }
        fun generateTrees(n: Int): List<TreeNode?> {
            if (n == 0) {
                return emptyList()
            }
            val ans = mutableListOf<TreeNode?>()
            for (i in 1..n) {
                ans.addAll(dfs(i, 1, n))
            }
            return ans
        }

        private fun dfs(cur: Int, lo: Int, hi: Int): List<TreeNode?> {
            if (lo > hi) return listOf(null)
            if (lo == hi) {
                return listOf(TreeNode(lo))
            }
            val lefts = mutableListOf<TreeNode?>()
            for (i in lo until cur) {
                lefts.addAll(dfs(i, lo, cur - 1))
            }
            val rights = mutableListOf<TreeNode?>()
            for (i in cur + 1..hi){
                rights.addAll(dfs(i, cur + 1, hi))
            }
            if (lefts.isEmpty()) {
                lefts.add(null)
            }
            if (rights.isEmpty()) {
                rights.add(null)
            }
            val ans = mutableListOf<TreeNode>()
            for (left in lefts) {
                for (right in rights) {
                    val root = TreeNode(cur)
                    root.left = left
                    root.right = right
                    ans.add(root)
                }
            }
            return ans
        }
    }
}