import java.util.HashSet

class _52 {
    var ans = 0
    fun totalNQueens(n: Int): Int {
        val columns = hashSetOf<Int>()
        val diag1 = hashSetOf<Int>()
        val diag2 = hashSetOf<Int>()
        dfs(n, 0, columns, diag1, diag2)
        return ans
    }

    private fun dfs(n: Int, row: Int, columns: HashSet<Int>, diag1: HashSet<Int>, diag2: HashSet<Int>) {
        if (row == n) {
            ans++
            return
        }
        for (c in 0 until n) {
            val d1 = row + c
            val d2 = row - c
            if (columns.contains(c) || diag1.contains(d1) || diag2.contains(d2))
                continue
            columns.add(c)
            diag1.add(d1)
            diag2.add(d2)
            dfs(n, row + 1, columns, diag1, diag2)
            columns.remove(c)
            diag1.remove(d1)
            diag2.remove(d2)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(_52().totalNQueens(4))
        }
    }
}