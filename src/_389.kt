class _389 {
    companion object {

        fun findTheDifference(s: String, t: String): Char {
            val mark = IntArray(26)
            for (i in s.indices) {
                mark[t[i] - 'a']++
                mark[s[i] - 'a']--
            }
            mark[t.last() - 'a']++
            return (mark.find { it != 0 }!! + 'a'.toInt()).toChar()
        }

    }
}