class _190 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun reverseBits(n: Int): Int {
            var ans = 0
            for (i in 0..31) {
                if (n.shr(i).and(0) == 1) {
                    ans = ans.or(1.shl(31 - i))
                }
            }
            return ans
        }
    }
}