class _841 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
            val n = rooms.size
            val mark = BooleanArray(n)
            dfs(rooms, 0, mark)
            return mark.any { !it }
        }

        private fun dfs(rooms: List<List<Int>>, k: Int, mark: BooleanArray) {
            if (mark[k]) return
            mark[k] = true
            for (next in rooms[k]) {
                dfs(rooms, next, mark)
            }
        }
    }
}