class _134 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(canCompleteCircuit2(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
        }

        fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
            val len = gas.size
            var idx = -1
            var left = 0
            var minLeft = Int.MAX_VALUE
            for (i in 0 until len) {
                left += gas[i] - cost[i]
                if (left < minLeft) {
                    minLeft = left
                    idx = i
                }
            }
            return if (left < 0) -1 else (idx + 1) % len
        }

        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            val len = gas.size
            for (i in 0 until len) {
                if (dfs(gas, cost, i, 0, 0)) {
                    return i
                }
            }
            return -1
        }

        private fun dfs(gas: IntArray, cost: IntArray, k: Int, cur: Int, vis: Int): Boolean {
            if (vis == gas.size) {
                return true
            }
            if (gas[k] + cur < cost[k])
                return false
            return dfs(gas, cost, (k + 1) % gas.size, gas[k] + cur - cost[k], vis + 1)
        }
    }
}