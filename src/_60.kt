import sort.swap

class _60 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            TODO()
            val message = getPermutation(3, 3)
            println("....")
            println(message)
        }

        fun getPermutation(n: Int, k: Int): String {
            val nums = IntArray(n) { it + 1 }
            var multi = 1
            for (i in 1..n) {
                multi *= i
            }
            dfs(nums, 0, k)
            return ans
        }

        var ans = ""
        var idx = 0

        private fun dfs(nums: IntArray, i: Int, k: Int) {
            if (i == nums.size) {
                idx++
                println(nums.joinToString(""))
                if (idx == k)
                    ans = nums.joinToString("")
                return
            }
            if (i >= nums.size)
                return
            for (j in i until nums.size) {
                nums.swap(i, j)
                dfs(nums, i + 1, k)
                nums.swap(i, j)
            }
        }
    }
}