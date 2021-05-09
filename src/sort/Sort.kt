package sort

import java.util.*


fun IntArray.swap(i: Int, j: Int) {
    val t = this[i]
    this[i] = this[j]
    this[j] = t
}

fun bubbleSort(nums: IntArray) {
    for (i in nums.indices) {
        for (j in 0 until nums.size - i - 1) {
            if (nums[j] > nums[j + 1]) {
                nums.swap(j, j + 1)
            }
        }
    }
}

fun selectionSort(nums: IntArray) {
    for (i in nums.indices) {
        var min = i
        for (j in i until nums.size) {
            if (nums[j] < nums[min]) {
                min = j
            }
        }
        nums.swap(i, min)
    }
}

fun insertionSort(nums: IntArray) {
    for (i in 1 until nums.size) {
        val n = nums[i]
        var j = i
        while (j > 0 && n < nums[j - 1]) {
            nums[j] = nums[j - 1]
            j--
        }
        nums[j] = n
    }
}

fun shellSort(nums: IntArray) {
    var step = nums.size / 2
    while (step >= 1) {
        for (i in step until nums.size) {
            val n = nums[i]
            var j = i - step
            while (j >= 0 && nums[j] > n) {
                nums[j + step] = nums[j]
                j -= step
            }
            nums[j + step] = n
        }
        step /= 2
    }
}


fun shellSort2(nums: IntArray) {
    var step = nums.size / 2
    while (step >= 1) {
        for (i in step until nums.size) {
            val n = nums[i]
            var j = i
            while (j - step >= 0 && nums[j - step] >= n) {
                nums[j] = nums[j - step]
                j -= step
            }
            nums[j] = n
        }
        step /= 2
    }
}

fun merge(lh: IntArray, rh: IntArray): IntArray {
    val assign = IntArray(lh.size + rh.size)
    var i = 0
    var j = 0
    var idx = 0
    while (i < lh.size || j < rh.size) {
        if (i == lh.size) {
            assign[idx++] = rh[j++]
        } else if (j == rh.size) {
            assign[idx++] = lh[i++]
        } else if (lh[i] < rh[j]) {
            assign[idx++] = lh[i++]
        } else {
            assign[idx++] = rh[j++]
        }
    }
    return assign
}

fun mergeSort(nums: IntArray): IntArray {
    if (nums.size <= 1) return nums
    val mid = (nums.size - 1) / 2
    val lh = mergeSort(nums.copyOfRange(0, mid))
    val rh = mergeSort(nums.copyOfRange(mid, nums.size))
    return merge(lh, rh)
}

fun quickSort(nums: IntArray) {
    quick(nums, 0, nums.size - 1)
}

fun quick(nums: IntArray, lo: Int, hi: Int) {
    if (lo >= hi) return
    val idx = partition(nums, lo, hi)
    quick(nums, lo, idx - 1)
    quick(nums, idx + 1, hi)
}

fun partition(nums: IntArray, lo: Int, hi: Int): Int {
    var idx = lo + 1
    for (i in idx..hi) {
        if (nums[i] < nums[lo]) {
            nums.swap(i, idx)
            idx++
        }
    }
    nums.swap(lo, idx - 1)
    return idx - 1
}


fun bucketSort(nums: IntArray) {
    if (nums.isEmpty()) return

    val max = nums.max()!!
    val min = nums.min()!!
    val bucketSize = 4
    val diff = max - min
    val buckets = Array<MutableList<Int>>(bucketSize) { arrayListOf() }
    //每个桶的存放区间
    val section: Float = diff.toFloat() / (bucketSize)
    for (i in nums.indices) {
        val idx = Math.min(buckets.lastIndex, (nums[i] / section).toInt())
        buckets[idx].add(nums[i])
    }
    buckets.forEach { it.sort() }
    var id = 0
    for (b in buckets) {
        for (v in b)
            nums[id++] = v
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    bubbleSort(nums)
//    selectionSort(nums)
//    selectionSort(nums)
//    shellSort2(nums)
//    println(mergeSort(nums))
//    quickSort(nums)
    bucketSort(nums)
    println(nums.joinToString())
}

fun part(nums: IntArray, lo: Int, hi: Int): Int {
    var idx = lo + 1
    for (i in (lo + 1)..hi) {
        if (nums[i] < nums[lo]) {
            nums.swap(i, idx++)
        }
    }
    nums.swap(idx - 1, lo)
    return idx - 1
}