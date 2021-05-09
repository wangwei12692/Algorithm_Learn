class _18 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(
                fourSum(
                    intArrayOf(1, 0, -1, 0, -2, 2), 0
                )
            )
            println(
                fourSumDFS(
                    intArrayOf(1, 0, -1, 0, -2, 2), 0
                )
            )
        }

        fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
            if (nums.size < 4)
                return emptyList()
            val ans = mutableListOf<List<Int>>()
            nums.sort()

            for (i in 0 until nums.size) {
                for (j in i + 1 until nums.size) {
                    var lo = j + 1
                    var hi = nums.size - 1
                    while (lo < hi) {
                        val sum = nums[i] + nums[j] + nums[lo] + nums[hi]
                        if (sum == target) {
                            while (lo < hi && nums[lo] == nums[lo + 1])
                                lo++
                            while (lo < hi && nums[hi] == nums[hi - 1])
                                hi--
                            ans.add(listOf(nums[i], nums[j], nums[lo], nums[hi]))
                            lo++
                            hi--
                        } else if (sum < target) {
                            lo++
                        } else {
                            hi--
                        }
                    }
                }
            }

            return ans
        }

        fun fourSumDFS(nums: IntArray, target: Int): List<List<Int>> {
            if (nums.size < 4)
                return emptyList()
            val ans = mutableListOf<List<Int>>()
            nums.sort()
            dfs(nums, 0, target, ans, mutableListOf<Int>())
            return ans
        }

        private fun dfs(nums: IntArray, k: Int, target: Int, ans: MutableList<List<Int>>, line: MutableList<Int>) {
            if (line.size > 4) return
            if (line.size == 4) {
                if (target == 0) {
                    ans.add(line.toList())
                }
                return
            }
            var i = k
            while (i < nums.size) {
                if (nums[i] * (4 - line.size) > target) {
                    break
                }
                if (i + 1 < nums.size && (4 - line.size) * nums.last() < target) {
                    i++
                    continue
                }
                line.add(nums[i])
                dfs(nums, i + 1, target - nums[i], ans, line)
                line.removeAt(line.size - 1)
                while (i + 1 <= nums.lastIndex && nums[i + 1] == nums[i]) {
                    i++
                }
                i++
            }
        }


    }
}