class _1624 {
    companion object {
        fun maxLengthBetweenEqualCharacters(s: String): Int {
            val mark = IntArray(26) { -1 }
            var max = 0
            for ((i, v) in s.withIndex()) {
                if (mark[v - 'a'] == -1) {
                    mark[v - 'a'] = i
                } else {
                    val last = mark[v - 'a']
                    max = Math.max(i - last - 1, max)
                }
            }
            return max
        }
    }
}