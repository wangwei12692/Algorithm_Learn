class _461 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(hammingDistance(1,4))
        }
        fun hammingDistance(x: Int, y: Int): Int {
            var n = x.xor(y)
            var ans = 0
            while (n != 0) {
                n = n.and(n - 1)
                ans++
            }
            return ans
        }
    }
}