class _1518 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(numWaterBottles(9, 3))
        }

        fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
            return dfs(numBottles, numExchange, 0)
        }

        private fun dfs(numBottles: Int, numExchange: Int, emptyBottles: Int): Int {
            if (numBottles + emptyBottles < numExchange) {
                return numBottles
            }
            return numBottles + dfs((numBottles + emptyBottles) / numExchange, numExchange,(numBottles + emptyBottles) % numExchange)
        }
    }
}