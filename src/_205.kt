class _205 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(isIsomorphic("abb", "cdd"))
        }

        fun isIsomorphic(s: String, t: String): Boolean {
            if (s.length != t.length)
                return false
            val s2t = hashMapOf<Char, Char>()
            val t2s = hashMapOf<Char, Char>()
            for (i in s.indices) {
                if (s2t[s[i]] != null && s2t[s[i]] != t[i]
                    || t2s[t[i]] != null && t2s[t[i]] != s[i]) {
                    return false
                }
                s2t[s[i]] = t[i]
                t2s[t[i]] = s[i]

            }
            return true
        }
    }
}