class _14 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                longestCommonPrefix(
                    arrayOf(
                        "dog","racecar","car"
                    )
                )
            )
        }
        fun longestCommonPrefix(strs: Array<String>): String {
            val len = strs.minOf { it.length }
            var max = 0
            var isBreak = false
            for (i in 0 until len) {
                if (isBreak) break
                for (j in 1 until strs.size) {
                    if (strs[j][i] != strs[j - 1][i]) {
                        max = i
                        isBreak = true
                        break
                    }
                }
            }
            return strs[0].substring(0, if (isBreak) max else len + 1)
        }
    }
}