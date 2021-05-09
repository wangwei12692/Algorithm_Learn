class _1361{
    companion object{
        fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
            val inDeg = IntArray(n)
            for (i in 0 until n) {
                if (leftChild[i] != -1)
                    inDeg[leftChild[i]]++
                else if (rightChild[i] != -1)
                    inDeg[rightChild[i]]++
            }
            var root = -1
            for ((i, v) in inDeg.withIndex()) {
                if (v == 1 && root != -1) {
                    return false
                }
                if (v == 1)
                    root = i
            }
            if (root == -1) return false
            val marked = BooleanArray(n)
            return dfs(root, leftChild, rightChild, marked)
        }

        fun dfs(root: Int, leftChild: IntArray, rightChild: IntArray, marked: BooleanArray): Boolean {
            if (root == -1) return true
            if (marked[root]) return false
            marked[root] = true
            return dfs(leftChild[root], leftChild, rightChild, marked) && dfs(rightChild[root], leftChild, rightChild, marked)
        }
    }
}