class _28 {
    companion object {
        fun strStr(haystack: String, needle: String): Int {
            if (needle.isEmpty() || needle.length > haystack.length)
                return 0
            var ans = 0
            var find = false
            for (i in 0 until haystack.length - needle.length) {
                if (find) break
                if (needle[0] == haystack[i]) {
                    ans = i
                    var lo = i
                    for (j in needle.indices) {
                        if (haystack[lo++] != needle[j]) {
                            break
                        } else if (j == needle.length - 1) {
                            find = true
                            break
                        }
                    }
                }
            }
            return if (find) ans else -1
        }
    }
}