class _997 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun findJudge(N: Int, trust: Array<IntArray>): Int {
            val inDeg = IntArray(N)
            val outDeg = IntArray(N)
            for ((a, b) in trust) {
                outDeg[a]++
                inDeg[b]++
            }
            for (i in 0 until N) {
                if (inDeg[i] == N - 1 && outDeg[i] == 0)
                    return i
            }
            return -1
        }
    }
}