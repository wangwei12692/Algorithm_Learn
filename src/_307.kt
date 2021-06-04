
class _307 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
//            val array = NumArray(intArrayOf(1, 3, 5, 7, 9))
//            println(array.tree.joinToString())
//            println(array.sumRange(1, 4))
//            array.update(2, 10)
//            println(array.sumRange(1, 4))

            println(">>>>>>>>>>>>>>>>>>>>>>>")
            val array2 = NumArray2(intArrayOf(1, 3, 5, 7, 9))
            println(array2.tree.joinToString())
            println(array2.sumRange(1, 4))

            println(">>>>>>>>>>>>>>>>>>>>>>>")
            val array3 = NumArr3(intArrayOf(1, 3, 5, 7, 9))
            println(array3.printTree(array3.root))
            println(array3.sumRange(1, 4))
        }


        class NumArray(private val nums: IntArray) {
            val tree = IntArray(nums.size * 2)

            init {
                val n = nums.size
                var j = 0
                for (i in n until 2 * n) {
                    tree[i] = nums[j++]
                }
                for (i in n - 1 downTo 1) {
                    tree[i] = tree[i * 2] + tree[i * 2 + 1]
                }
            }

            fun update(index: Int, `val`: Int) {
                var idx = index + nums.size
                tree[idx] = `val`
                while (idx > 0) {
                    var left = idx
                    var right = idx
                    if (idx % 2 == 0) {
                        right = idx + 1
                    } else {
                        left = idx - 1
                    }
                    tree[idx / 2] = tree[left] + tree[right]
                    idx /= 2
                }

            }

            //0, 35, 29, 6, 12, 17, 2, 4, 5, 7, 8, 9
            fun sumRange(left: Int, right: Int): Int {
                var lo = left + nums.size
                var hi = right + nums.size
                var sum = 0
                while (lo <= hi) {
                    if (lo % 2 == 1) { // i 为右孩子，孤立节点
                        sum += tree[lo]
                        lo++
                    }
                    if (hi % 2 == 0) { //j 为左孩子，孤立节点
                        sum += tree[hi]
                        hi--
                    }
                    lo /= 2
                    hi /= 2
                }
                return sum
            }

        }

        class NumArray2(private val nums: IntArray) {
            val tree = IntArray(nums.size * 4)
            private val n = nums.size

            init {
                build(1, 0, n - 1)
            }

            private fun build(node: Int, lo: Int, hi: Int) {
                if (lo == hi) {
                    tree[node] = nums[lo]
                    return
                }
                val mid = lo + (hi - lo) / 2
                val leftNode = 2 * node
                val rightNode = 2 * node + 1
                build(leftNode, lo, mid)
                build(rightNode, mid + 1, hi)
                tree[node] = tree[leftNode] + tree[rightNode]
            }

            fun update(index: Int, `val`: Int) {
                updateTree(1, 0, n - 1, index, `val`)
            }

            private fun updateTree(node: Int, lo: Int, hi: Int, idx: Int, `val`: Int) {
                if (lo == hi) {
                    tree[node] = `val`
                    nums[idx] = `val`
                    return
                }
                val mid = lo + (hi - lo) / 2
                val leftNode = 2 * node
                val rightNode = 2 * node + 1
                if (idx in lo..mid) {
                    updateTree(leftNode, lo, mid, idx, `val`)
                } else {
                    updateTree(rightNode, mid + 1, hi, idx, `val`)
                }
                tree[node] = tree[leftNode] + tree[rightNode]
            }

            fun sumRange(left: Int, right: Int): Int {
                return queryTree(1, 0, n - 1, left, right)
            }


            private fun queryTree(node: Int, lo: Int, hi: Int, i: Int, j: Int): Int {
                if (lo > j || hi < i) return 0
                if (i <= lo && hi <= j) {
                    println("use node $node")
                    return tree[node]
                }
                val mid = lo + (hi - lo) / 2
                val left = 2 * node
                val right = 2 * node + 1
                val sumLeft = queryTree(left, lo, mid, i, j)
                val sumRight = queryTree(right, mid + 1, hi, i, j)
                return sumLeft + sumRight
            }
        }

        class NumArr3(val nums: IntArray) {
            private val n = nums.size - 1

            data class TreeNode(
                var `val`: Int = 0,
                val lo: Int,
                val hi: Int,
                var left: TreeNode? = null,
                var right: TreeNode? = null
            )

            val root = buildTree(0, n)!!

            fun printTree(root: TreeNode?) {
                if (root == null) return
                printTree(root.left)
                print(root.`val`)
                print(", ")
                printTree(root.right)
            }

            private fun buildTree(lo: Int, hi: Int): TreeNode? {
                if (lo > hi) return null
                val curr = TreeNode(lo = lo, hi = hi)
                if (lo == hi) {
                    curr.`val` = nums[lo]
                } else {
                    val mid = lo + (hi - lo) / 2
                    curr.left = buildTree(lo, mid)
                    curr.right = buildTree(mid + 1, hi)
                    curr.`val` = curr.left!!.`val` + curr.right!!.`val`
                }
                return curr
            }

            fun update(index: Int, `val `: Int) {
                updateTree(root, index, `val `)
            }

            private fun updateTree(node: TreeNode, index: Int, v: Int) {
                if (node.lo == node.hi) {
                    nums[index] = v
                    node.`val` = v
                } else {
                    val mid = node.lo + (node.hi - node.lo) / 2
                    if (index <= mid) {
                        updateTree(node.left!!, index, v)
                    } else {
                        updateTree(node.right!!, index, v)
                    }
                    node.`val` = node.left!!.`val` + node.right!!.`val`
                }
            }

            fun sumRange(lo: Int, hi: Int): Int {
                return queryTree(root, lo, hi)
            }

            private fun queryTree(node: TreeNode, i: Int, j: Int): Int {
                if (node.lo == i && node.hi == j) {
                    println("use: ${node.`val`}")
                    return node.`val`
                } else {
                    val mid = node.lo + (node.hi - node.lo) / 2
                    if (j <= mid) {
                        return queryTree(node.left!!, i, j)
                    } else if (i >= (mid + 1)) {
                        return queryTree(node.right!!, i, j)
                    } else {
                        return queryTree(node.left!!, i, mid) + queryTree(node.right!!, mid + 1, j)
                    }
                }
            }

            private fun queryTree2(node: TreeNode, i: Int, j: Int): Int {
                val lo = node.lo
                val hi = node.hi
                if (lo > j || hi < i) return 0
                if (i <= lo && hi <= j) {
                    println("use node $node")
                    return node.`val`
                }
                val mid = lo + (hi - lo) / 2
                val sumLeft = queryTree2(node.left!!, i, j)
                val sumRight = queryTree2(node.right!!, i, j)
                return sumLeft + sumRight
            }
        }
    }
}