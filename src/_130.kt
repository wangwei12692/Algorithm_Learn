import java.util.*

class _130 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val board = arrayOf(
                charArrayOf('X', 'O', 'X', 'O', 'X', 'O'),
                charArrayOf('O', 'X', 'O', 'X', 'O', 'X'),
                charArrayOf('X', 'O', 'X', 'O', 'X', 'O'),
                charArrayOf('O', 'X', 'O', 'X', 'O', 'X')
            )
            solve(board)
            println(board.contentDeepToString())
        }

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        fun solve(board: Array<CharArray>): Unit {
            val m = board.size
            val n = board[0].size
            val q: Queue<Int> = LinkedList()
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                        q.offer(i * n + j)
                    }
                }
            }


            while (q.isNotEmpty()) {
                val size = q.size
                for (idx in 0 until size) {
                    val f = q.poll()
                    val i = f / n
                    val j = f % n
                    board[i][j] = 'Z'
                    for (dir in dirs) {
                        val ni = dir[0] + i
                        val nj = dir[1] + j
                        if (ni in 0 until m && nj in 0 until n && board[ni][nj] == 'O') {
                            q.offer(ni * n + nj)
                        }
                    }
                }
            }

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X'
                    else if (board[i][j] == 'Z')
                        board[i][j] = 'O'
                }
            }
        }
    }

}