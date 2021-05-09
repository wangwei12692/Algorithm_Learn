class _1042 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                gardenNoAdj(
                    4, arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(4, 3),
                    )
                ).joinToString()
            )
        }
        //无向图
        fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
            val graph = Array(n + 1) { mutableListOf<Int>() }
            for ((u, v) in paths) {
                graph[u].add(v)
                graph[v].add(u)
            }
            val ans = IntArray(n)
            for (i in 1..n) {
                val used = BooleanArray(5)
                for (u in graph[i]) {
                    used[ans[u - 1]] = true
                }
                for (j in 1..4) {
                    if (!used[j]) {
                        ans[i-1] = j
                        break
                    }
                }
            }
            return ans
        }
    }
}