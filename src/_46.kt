class _46 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(permute(intArrayOf(1, 2, 3)))
        }

        fun permute(nums: IntArray): List<List<Int>> {
            val ans = mutableListOf<List<Int>>()
            dfs(nums, 0, ans)
            return ans
        }

        private fun dfs(nums: IntArray, k: Int, ans: MutableList<List<Int>>) {
            if (k == nums.size) {
                ans.add(nums.toList())
                return
            }

            for (i in k until nums.size) {
                nums.swap(i, k)
                dfs(nums, k + 1, ans)
                nums.swap(i, k)
            }
        }

        private fun IntArray.swap(x: Int, y: Int) {
            val t = this[x]
            this[x] = this[y]
            this[y] = t
        }
    }
}