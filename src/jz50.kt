class jz50 {
    companion object {
        fun firstUniqChar(s: String): Char {
            if (s == "") {
                return ' '
            }
            val mark = IntArray(128)
            for (c in s) {
                mark[c.toInt()]++
            }
            for (c in s) {
                if (mark[c.toInt()] == 1)
                    return c
            }
            return ' '
        }
    }
}