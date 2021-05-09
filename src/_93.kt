class _93 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(restoreIpAddresses("25525511135"))
        }

        fun restoreIpAddresses(s: String): List<String> {
            val ans = mutableListOf<String>()
            dfs(s, 0, ans, mutableListOf<String>())
            return ans
        }

        private fun dfs(s: String, k: Int, ans: MutableList<String>, line: MutableList<String>) {
            if (k >= s.length || line.size > 4) {
                if (line.size == 4) {
                    ans.add(line.joinToString("."))
                }
                return
            }

            val v = (s[k] - '0')
            line.add(v.toString())
            dfs(s, k + 1, ans, line)
            line.removeLast()

            if (k + 1 < s.length) {
                val v = (s[k] - '0') * 10 + (s[k + 1] - '0')
                line.add(v.toString())
                dfs(s, k + 2, ans, line)
                line.removeLast()
            }
            var num = 0
            if (k + 2 < s.length && (((s[k] - '0') * 100 + (s[k + 1] - '0') * 10 + (s[k + 2] - '0')).also { num =it } <= 255)) {
//                val v = (s[k] - '0') * 100 + (s[k + 1] - '0') * 10 + (s[k + 2] - '0')
                line.add(num.toString())
                dfs(s, k + 3, ans, line)
                line.removeLast()
            }
        }
    }
}