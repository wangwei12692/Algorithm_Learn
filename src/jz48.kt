class jz48 {
    companion object {
        fun lengthOfLongestSubstring(s: String): Int {
            val map = mutableMapOf<Char, Int>()
            var ans = 0
            var last = 0
            for (i in s.indices) {
                if (map.containsKey(s[i])) {
                    last = Math.max(last, map[s[i]]!!)
                }
                ans = Math.max(ans, i - last)
                map[s[i]] = i
            }
            return ans
        }
    }
}