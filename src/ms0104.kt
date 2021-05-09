class ms0104 {
    companion object {
        fun canPermutePalindrome(s: String): Boolean {
            val mark = IntArray(128)
            for (c in s) {
                mark[c.toInt()]++
            }
            return mark.count { it % 2 == 1 } <= 1
        }
    }
}