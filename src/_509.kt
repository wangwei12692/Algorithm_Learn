class _509 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(fib(4))
        }


        fun fib2(n: Int) :Int{
            val memo = IntArray(n + 1)
            return dfs(n, memo)
        }

        private fun dfs(n: Int, memo: IntArray):Int {
            if (n <= 2) return n
            if (memo[n] != 0) {
                return memo[n]
            }
            val v = dfs(n - 1, memo) + dfs(n - 2, memo)
            memo[n] = v
            return v
        }

        fun fib(n: Int): Int {
            if (n <= 1) {
                return n
            }
            var a = 0
            var b = 1
            var idx = 1
            while (idx++ < n) {
                val t = b
                b = a + b
                a = t
            }
            return b
        }
    }
}