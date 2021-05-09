class _242 {
    companion object {
        fun isAnagram(s: String, t: String): Boolean {
            if (s.length != t.length)
                return false
            val acc = IntArray(26)
            for (i in s.indices) {
                acc[s[i] - 'a']++
                acc[t[i] - 'a']++
            }
            return acc.all { it == 0 }
        }
    }
}