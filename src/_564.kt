class _564 {
    companion object {
        fun nearestPalindromic(n: String): String {
            if(isDown(n)) return (n.toInt()-1).toString()
            TODO()
        }

        fun isDown(n: String): Boolean {
            if (n[0] != '1') return false
            for (i in 1 until n.length) {
                if (n[i] != '0') {
                    return false
                }
            }
            return true
        }
    }
}