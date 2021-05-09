class _89 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(grayCode2(3))
            println(grayCode(3))
        }

        fun grayCode(n: Int): List<Int> {
            val ans = mutableListOf<Int>()
            dfs(ans, n, 0, 0, true)
            return ans
        }

        private fun dfs(ans: MutableList<Int>, n: Int, pos: Int, num: Int, first: Boolean) {
            if (pos == n) {
                ans.add(num)
                return
            }
            if (first) {
                dfs(ans, n, pos + 1, num.shl(1), true)
                dfs(ans, n, pos + 1, num.shl(1) + 1, false)
            } else {
                dfs(ans, n, pos + 1, num.shl(1) + 1, true)
                dfs(ans, n, pos + 1, num.shl(1), false)
            }
        }

        fun grayCode2(n: Int): List<Int> {
            if (n == 0) return listOf(0)
            val last = grayCode2(n - 1)
            val ans = mutableListOf<Int>()
            for (i in last.size - 1 downTo 0) {
                val cur = last[i]
                ans.add((1 shl n - 1) or cur)
            }
            return last + ans
        }


    }
}