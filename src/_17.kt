import java.lang.StringBuilder

class _17 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(letterCombinations("23"))
        }

        private val map = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz",
        )

        fun letterCombinations(digits: String): List<String> {
            val ans = mutableListOf<String>()
            dfs(digits, 0, ans, StringBuilder())
            return ans
        }

        private fun dfs(digits: String, k: Int, ans: MutableList<String>, sb: StringBuilder) {
            if (k == digits.length) {
                ans.add(sb.toString())
                return
            }
            for (c in map[digits[k]]!!) {
                sb.append(c)
                dfs(digits, k + 1, ans, sb)
                sb.deleteAt(sb.length - 1)
            }
        }
    }
}