class _47 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(permuteUnique(intArrayOf(1, 2,3)))
        }

        fun permuteUnique(nums: IntArray): List<List<Int>> {
            nums.sort()
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
                if (!nums.notUsed(k, i)) {
                    //k -- i，前面的区间已经出现过 nums[i] 了
                    continue
                }
                nums.swap(i, k)
                dfs(nums, k + 1, ans)
                nums.swap(i, k)
            }

        }

        private fun IntArray.notUsed(lo: Int, hi: Int): Boolean {
//            for (i in lo until hi) {
//                if (this[i] == this[hi])
//                    return false
//            }
//            return true

            return (lo until hi).all { this[it] != this[hi] }
        }

        private fun IntArray.swap(i: Int, j: Int) {
            val x = this[i]
            this[i] = this[j]
            this[j] = x
        }
    }
}