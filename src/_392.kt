class _392 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(isSubsequence2("abc", "ahbgdc"))
        }


        fun isSubsequence2(s: String, t: String): Boolean {
            val n = s.length
            val m = t.length
            //序列自动机
            // f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置
            val dp = Array(m + 1) { IntArray(26) { m } }
            for (i in m - 1 downTo 0) {
                for (j in 0 until 26) {
                    if (j + 'a'.toInt() == t[i].toInt()) {
                        dp[i][j] = i
                    } else {
                        dp[i][j] = dp[i + 1][j]
                    }
                }
            }
            var add = 0
            for (i in 0 until n) {
                val last = dp[add][s[i] - 'a']
                if (last == m) {
                    return false
                }
                add = last + 1
            }
            return true
        }

        fun isSubsequence(s: String, t: String): Boolean {
            if (s.length > t.length) return false
            var i = s.length - 1
            var j = t.length - 1
            while (i >= 0 && j >= 0) {
                if (s[i] == t[j]) {
                    i--
                    j--
                } else {
                    j--
                }
            }
            return i == -1
        }
    }
}