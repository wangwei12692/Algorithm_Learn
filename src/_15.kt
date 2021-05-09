class _15{
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val ans = mutableListOf<List<Int>>()
        nums.sort()
        for ((i, v) in nums.withIndex()) {
            if (v > 0) break
            var lo = i + 1
            var hi = nums.size - 1
            if (i > 0 && nums[i - 1] == v)
                continue
            while (lo < hi) {
                val cmp = v + nums[lo] + nums[hi]
                when {
                    cmp == 0 -> {
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--
                        }
                        ans.add(listOf(v, nums[lo], nums[hi]))
                        lo++
                        hi--
                    }
                    cmp > 0 -> {
                        hi--
                    }
                    else -> {
                        lo++
                    }
                }
            }
        }
        return ans
    }

    fun threeSumDegree(nums: IntArray): List<List<Int>> {
        if (nums.size < 3)
            return emptyList()
        val ans = mutableListOf<List<Int>>()
        nums.sort()
        val marked = hashSetOf<Int>()
        for ((i, v) in nums.withIndex()) {
            if (v > 0 || i + 2 >= nums.size)
                break
            if (marked.contains(v))
                continue
            marked.add(v)
            val res = twoSum(nums, i + 1, -v)
            if (res.isEmpty())
                continue
            for ((m, n) in res) {
                ans.add(listOf<Int>(v, m, n))
            }
        }
        return ans
    }

    private fun twoSum(nums: IntArray, k: Int, target: Int): List<IntArray> {
        val map = hashMapOf<Int, Int>()
        val ans = mutableListOf<IntArray>()
        val excludes = mutableSetOf<Int>()
        for (i in k until nums.size) {
            if (excludes.contains(nums[i]))
                continue
            excludes.add(nums[i])

            val idx = map[target - nums[i]]
            if (idx != null) {
                ans.add(intArrayOf(target - nums[i], nums[i]))
            } else {
                map[nums[i]] = i
            }
        }
        return ans
    }

    fun threeSumDFS(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val ans = mutableListOf<List<Int>>()
        nums.sort()
        dfs(0, nums, ans, 0, mutableListOf<Int>())
        return ans
    }

    private fun dfs(k: Int, nums: IntArray, ans: MutableList<List<Int>>, target: Int, line: MutableList<Int>) {
        if (line.size > 3) {
            return
        }
        if (line.size == 3) {
            if (target == 0) {
                ans.add(line.toList())
            }
            return
        }
        if (k >= nums.size)
            return
        //[[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
        var i = k
        while (i < nums.size) {
            if ((3 - line.size) * nums[i] > target) {
                break
            }
            if (i + 1 < nums.size && (3 - line.size) * nums[nums.size - 1] < target) {
                i++
                continue
            }
            line.add(nums[i])
            dfs(i + 1, nums, ans, target - nums[i], line)
            line.removeAt(line.size - 1)
            while (i + 1 < nums.size && nums[i] == nums[i + 1]) {
                //dup
                i++
            }
            i++
        }
    }
}