class _1160 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun countCharacters(words: Array<String>, chars: String): Int {
            val cs = IntArray(26)
            for (c in chars) {
                cs[c - 'a']++
            }
            var len = 0
            for (word in words) {
                val mark = cs.copyOf()
                var isFatal = false
                for (w in word) {
                    if (mark[w - 'a'] < 0) {
                        isFatal = true
                        break
                    } else {
                        mark[w - 'a']--
                    }
                }
                if (!isFatal)
                    len += word.length
            }
            return len
        }
    }
}