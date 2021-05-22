class _131 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(partition("aab"))

        }

        fun partition(s: String): List<List<String>> {
            val n = s.length
            val dp = Array(n) { i -> BooleanArray(n) { j -> i == j } }
            //dp[i][j] == s[i] == s[j] && dp[i+1][j-1]
            for (len in 1..n) {
                for (i in 0 until n - len) {
                    val j = len + i
                    if (len == 1) {
                        dp[i][j] = s[i] == s[j]
                    } else {
                        dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
                    }
                }
            }
            val ans = mutableListOf<List<String>>()
            dfs(s, dp, 0, mutableListOf(), ans)
//            dfs2(s, dp, 0, n - 1, mutableListOf(), ans)
            return ans
        }

        private fun dfs2(
            s: String,
            dp: Array<BooleanArray>,
            lo: Int,
            hi: Int,
            line: MutableList<String>,
            ans: MutableList<List<String>>
        ) {
            if (lo > hi) {
                ans.add(line.toList())
                return
            }
            for (i in 0..hi - lo) {
                if (dp[lo][lo + i]) {
                    line.add(s.substring(lo, lo + i + 1))
                    dfs2(s, dp, lo + i + 1, hi, line, ans)
                    line.removeLast()
                }
            }
        }

        private fun dfs(
            s: String,
            dp: Array<BooleanArray>,
            i: Int,
            line: MutableList<String>,
            ans: MutableList<List<String>>
        ) {
            if (i == dp.size) {
                ans.add(line.toList())
                return
            }
            for (j in i until dp.size) {
                if (dp[i][j]) {
                    line.add(s.substring(i, j + 1))
                    dfs(s, dp, j + 1, line, ans)
                    line.removeAt(line.lastIndex)
                }
            }
        }
    }
}