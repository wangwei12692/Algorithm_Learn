import java.util.HashSet

class _37 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val board = arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
            )
            solveSudoku(board)
            println(board.contentDeepToString())
        }

        fun solveSudoku(board: Array<CharArray>): Unit {
            val lines = Array(9) { hashSetOf<Int>() }
            val columns = Array(9) { hashSetOf<Int>() }
            val boxes = Array(9) { hashSetOf<Int>() }
            val nodes = mutableListOf<Int>()
            for (i in 0..8) {
                for (j in 0..8) {
                    if (board[i][j] == '.')
                        nodes.add(i * 10 + j)
                    else {
                        val c = board[i][j] - '0'
                        lines[i].add(c)
                        columns[j].add(c)
                        boxes[(i / 3) * 3 + j / 3].add(c)
                    }
                }
            }

            dfs(board, 0, nodes, lines, columns, boxes)
        }

        //dfs 推进什么，保证最后结果为true
        private fun dfs(
            board: Array<CharArray>,
            k: Int,
            nodes: List<Int>,
            lines: Array<HashSet<Int>>,
            columns: Array<HashSet<Int>>,
            boxes: Array<HashSet<Int>>
        ): Boolean {
            if (k == nodes.size) {
                return true
            }

            val i = nodes[k] / 10
            val j = nodes[k] % 10

            val av = (1..9).filter {
                !lines[i].contains(it) && !columns[j].contains(it)
                        && !boxes[(i / 3) * 3 + j / 3].contains(it)
            }

            for (n in av) {
                board[i][j] = (n + '0'.toInt()).toChar()
                lines[i].add(n)
                columns[j].add(n)
                boxes[(i / 3) * 3 + j / 3].add(n)
                if (dfs(board, k + 1, nodes, lines, columns, boxes)) {
                    return true
                }
                board[i][j] = '.'
                lines[i].remove(n)
                columns[j].remove(n)
                boxes[(i / 3) * 3 + j / 3].remove(n)
            }
            return false
        }
    }
}