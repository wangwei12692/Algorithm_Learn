class _637 {
    companion object {

        data class SumNode(var sum: Int, var count: Int) {
            val avg: Double = sum / count.toDouble()
        }

        fun averageOfLevels(root: TreeNode?): DoubleArray {
            if (root == null) return doubleArrayOf()
            val ans = mutableListOf<SumNode>()
            dfs(root, 0, ans)
            return ans.map { it.avg }.toDoubleArray()
        }

        private fun dfs(root: TreeNode?, k: Int, ans: MutableList<SumNode>) {
            if (root == null)
                return
            if (ans.size <= k) {
                ans.add(SumNode(0, 0))
            }
            ans[k].sum += root.`val`
            ans[k].count++
            dfs(root.left, k + 1, ans)
            dfs(root.right, k + 1, ans)
        }
    }
}