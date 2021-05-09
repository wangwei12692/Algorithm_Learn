class _36 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun isValidSudoku2(board: Array<CharArray>): Boolean {
            val lines = Array(9) { hashSetOf<Char>() }
            val columns = Array(9) { hashSetOf<Char>() }
            val boxes = Array(9) { hashSetOf<Char>() }
            for (i in 0..8) {
                for (j in 0..8) {
                    if (board[i][j] == '.') continue
                    val c = board[i][j]
                    if (lines[i].contains(c)
                        || columns[j].contains(c)
                        || boxes[(i / 3) * 3 + j / 3].contains(c)
                    ) {
                        return false
                    }
                    lines[i].add(c)
                    columns[j].add(c)
                    boxes[(i / 3) * 3 + j / 3].add(c)
                }
            }
            return true
        }

        fun isValidSudoku(board: Array<CharArray>): Boolean {
            if (board.any { !isRowValid(it) })
                return false
            if ((0..8).any { !isColumnValid(board, it) })
                return false
            for (i in 0..8 step 3) {
                for (j in 0..8 step 3) {
                    if (!isSquareValid(board, i, j)) {
                        return false
                    }
                }
            }
            return true
        }

        fun isRowValid(line: CharArray): Boolean {
            val flag = BooleanArray(9)
            for (c in line) {
                if (c == '.') continue
                if (flag[c - '1'])
                    return false
                flag[c - '1'] = true
            }
            return true
        }

        fun isColumnValid(board: Array<CharArray>, column: Int): Boolean {
            val flag = BooleanArray(9)
            for (i in 0..8) {
                val c = board[i][column]
                if (c == '.') continue
                if (flag[c - '1'])
                    return false
                flag[c - '1'] = true
            }
            return true
        }

        fun isSquareValid(board: Array<CharArray>, x: Int, y: Int): Boolean {
            val flag = BooleanArray(9)
            for (i in x..x + 2) {
                for (j in y..y + 2) {
                    val c = board[i][j]
                    if (c == '.') continue
                    if (flag[c - '1'])
                        return false
                    flag[c - '1'] = true
                }
            }
            return true
        }
    }
}