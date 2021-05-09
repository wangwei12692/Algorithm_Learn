import kotlin.math.max
import kotlin.math.min

class _351 {
    companion object {
        var patterns = 0
        fun numberOfPatterns(m: Int, n: Int): Int {
            val visited = BooleanArray(10)
            for (i in 1..9) {
                visited[i] = true
                dfs(visited, i, 1, m, n)
                visited[i] = false
            }
            return patterns
        }

        private fun dfs(visited: BooleanArray, from: Int, step: Int, m: Int, n: Int) {
            if (step == n) {
                patterns++
                return
            }
            if (step >= m) patterns++
            for (to in 1..9) {
                if (valid(visited, from, to)) {
                    visited[from] = true
                    dfs(visited, to, step + 1, m, n)
                    visited[from] = false
                }
            }
        }

        private fun valid(visited: BooleanArray, from: Int, to: Int): Boolean {
            if (from == to) return false
            val minV = min(from, to)
            val maxV = max(from, to)
            if ((minV == 1 && maxV == 9) || (minV == 3 && maxV == 7)) return visited[5] && !visited[to]
            if ((minV == 1 || minV == 4 || minV == 7) && minV + 2 == maxV) return visited[minV + 1] && !visited[to]
            if (minV <= 3 && minV + 6 == maxV) return visited[minV + 3] && !visited[to]

            return !visited[to]
        }
    }
}