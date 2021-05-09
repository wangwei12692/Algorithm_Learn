import sort.swap

class ms1714 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(smallestK(intArrayOf(1, 3, 5, 7, 2, 4, 6, 8), 4).joinToString())
            println(smallestK2(intArrayOf(1, 3, 5, 7, 2, 4, 6, 8), 4).joinToString())
        }

        fun smallestK2(arr: IntArray, k: Int): IntArray {
            return mergeSort(arr).copyOf(k)
        }

        fun mergeSort(nums: IntArray): IntArray {
            if (nums.size <= 1) return nums
            val mid = nums.size / 2
            val lh = mergeSort(nums.copyOfRange(0, mid))
            val rh = mergeSort(nums.copyOfRange(mid, nums.size))
            return merge(lh, rh)
        }

        fun merge(lh: IntArray, rh: IntArray): IntArray {
            return (lh + rh).apply { sort() }
        }


        fun smallestK(arr: IntArray, k: Int): IntArray {
            quickSort(arr)
            return arr.copyOf(k)
        }

        private fun quickSort(arr: IntArray) {
            quickSortHelper(arr, 0, arr.size - 1)
        }

        private fun quickSortHelper(arr: IntArray, lo: Int, hi: Int) {
            if (lo >= hi) return
            val part = part(arr, lo, hi)
            quickSortHelper(arr, lo, part - 1)
            quickSortHelper(arr, part + 1, hi)
        }

        private fun part(arr: IntArray, lo: Int, hi: Int): Int {
            var idx = lo + 1
            for (i in lo + 1..hi) {
                if (arr[i] < arr[lo]) {
                    arr.swap(i, idx++)
                }
            }
            arr.swap(lo, idx - 1)
            return idx - 1
        }
    }
}