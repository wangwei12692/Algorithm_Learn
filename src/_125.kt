class _125 {
    companion object {
        //统一转成大写：ch & 0b11011111 简写：ch & 0xDF
        //统一转成小写：ch | 0b00100000 简写：ch | 0x20
        fun isPalindrome(s: String): Boolean {
            var lo = 0
            var hi = s.length - 1
            while (lo < hi) {
                if (!s[lo].isLetter()) continue
                if (!s[hi].isLetter()) continue
                if (s[lo].toLowerCase() != s[hi].toLowerCase()) return false
                lo++
                hi--
            }
            return true
        }
    }
}