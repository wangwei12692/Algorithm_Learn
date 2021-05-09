import java.util.HashSet

class _1013 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(canThreePartsEqualSum(intArrayOf(
                0,2,1,-6,6,-7,9,1,2,0,1
            )))
        }

        fun canThreePartsEqualSum(arr: IntArray): Boolean {
            if (arr.size < 3)
                return false
            val sum = arr.sum()
            if (sum % 3 != 0)
                return false
            val used = hashSetOf<Int>()
            for (id in 0..1) {
                for (i in arr.indices) {
                    if (!used.contains(i)) {
                        if (!dfs(arr, 0, sum / 3, used))
                            return false
                        break
                    }
                }
            }
            return true
        }

        private fun dfs(arr: IntArray, k: Int, target: Int, used: HashSet<Int>): Boolean {
            if (target == 0)
                return true
            if (k >= arr.size)
                return false
            for (i in k until arr.size) {
                if (used.contains(i))
                    continue
                used.add(i)
                if (dfs(arr, i + 1, target - arr[i], used))
                    return true
                used.remove(i)
            }
            return false
        }
    }
}