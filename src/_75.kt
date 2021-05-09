class _75 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(2, 0, 2, 1, 1, 0)
//            sortColors(arr)
            sortColors2(arr)
            println(arr.joinToString())
        }

        fun sortColors(nums: IntArray): Unit {
            var lh = 0
            var rh = nums.size - 1
            var i = 0
            while (i in lh..rh) {
                if (nums[i] == 2) {
                    nums.swap(i, rh)
                    rh--
                } else if (nums[i] == 0) {
                    nums.swap(i, lh)
                    lh++
                    if (i <= lh) i = lh
                } else {
                    i++
                }
            }
        }

        fun IntArray.swap(i: Int, j: Int) {
            val tmp = this[i]
            this[i] = this[j]
            this[j] = tmp
        }

        fun sortColors2(nums: IntArray): Unit {
            val n = nums.size
            var ptr = 0
            for (i in 0 until n) {
                if (nums[i] == 0) {
                    nums.swap(i, ptr)
                    ptr++
                }
            }

            for (i in ptr until n) {
                if (nums[i] == 1) {
                    nums.swap(i, ptr)
                    ptr++
                }
            }

        }

        fun sortColors3(nums: IntArray): Unit {
            var lh = 0
            var rh = nums.lastIndex
            var i = 0
            while (i <= rh) {
                if (nums[i] == 0) {
                    nums.swap(i, lh)
                    lh++
                }
                while (nums[i] == 2 && i <= rh) {
                    nums.swap(i, rh)
                    rh--
                }
                i++
            }
        }

        fun sortColors4(nums: IntArray): Unit {
            var p0 = 0
            var p1 = 0
            for (i in nums.indices) {
                if (nums[i] == 1) {
                    nums.swap(i, p1)
                    p1++
                } else if (nums[i] == 0) {
                    nums.swap(i, p0)
                    if (p0 < p1) {
                        nums.swap(i, p1)
                    }
                    p0++
                    p1++
                }
            }
        }

    }
}