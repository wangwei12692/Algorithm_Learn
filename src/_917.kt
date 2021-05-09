class _917 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(reverseOnlyLetters("ab-cd"))
        }
        fun reverseOnlyLetters(S: String): String {
            var lo = 0
            var hi = S.length - 1
            val cs = S.toCharArray()
            while (lo < hi) {
                if (!cs[lo].isLetter()) lo++
                if (!cs[hi].isLetter()) hi--
                val t = cs[lo]
                cs[lo] = cs[hi]
                cs[hi] = t
                lo++
                hi--
            }
            return String(cs)
        }
    }
}