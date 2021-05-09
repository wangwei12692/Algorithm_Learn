import java.lang.StringBuilder

class _22 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(generateParenthesis(3))
        }


        fun generateParenthesis(n: Int): List<String> {
            val ans = mutableListOf<String>()
            dfs(3, 3, ans, StringBuilder())
            return ans
        }

        private fun dfs(left: Int, right: Int, ans: MutableList<String>, sb: StringBuilder) {
            if (left == 0 && right == 0) {
                ans.add(sb.toString())
                return
            }
            if (left > right || left < 0 || right < 0) {
                return
            }
            sb.append("(")
            dfs(left - 1, right, ans, sb)
            sb.deleteCharAt(sb.length - 1)
            sb.append(")")
            dfs(left, right - 1, ans, sb)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}