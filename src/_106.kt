class _106 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            buildTree(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3))
        }


        fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
            val inLen = inorder.size
            val postLen = postorder.size
            if (inLen != postLen)
                return null
            val map = mutableMapOf<Int, Int>()
            for (i in inorder.indices) {
                map[inorder[i]] = i
            }
            return build(postorder, 0, postLen - 1, map, 0, inLen - 1)
        }

        private fun build(
            postorder: IntArray,
            postLeft: Int,
            postRight: Int,
            map: MutableMap<Int, Int>,
            inLeft: Int,
            inRight: Int
        ): TreeNode? {
            if (postLeft > postRight || inLeft > inRight)
                return null

            val rootVal = postorder[postRight]
            val root = TreeNode(rootVal)
            val pIndex = map[rootVal]!!
            root.left = build(
                postorder, postLeft, postLeft + pIndex - inLeft-1,
                map, inLeft, pIndex - 1
            )
            root.right = build(
                postorder, postLeft + pIndex - inLeft, postRight - 1,
                map, pIndex + 1, inRight
            )
            return root
        }
    }
}