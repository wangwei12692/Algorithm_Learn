class _105 {
    companion object {
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            val preLen = preorder.size
            val inLen = inorder.size
            if (preLen != inLen) return null
            val map = mutableMapOf<Int, Int>()
            for (i in inorder.indices) {
                map[inorder[i]] = i
            }
            return build(preorder, 0, preLen - 1, map, 0, inLen - 1)
        }

        private fun build(
            preorder: IntArray,
            preLeft: Int,
            preRight: Int,
            map: MutableMap<Int, Int>,
            inLeft: Int,
            inRight: Int
        ): TreeNode? {
            if (preLeft > preRight || inLeft > inRight) {
                return null
            }
            val rootVal = preorder[preLeft]
            val root = TreeNode(rootVal)
            val pIndex = map[rootVal]!!

            root.left = build(
                preorder, preLeft + 1, pIndex - inLeft + preLeft,
                map, inLeft, pIndex - 1
            )
            root.right = build(
                preorder, pIndex - inLeft + preLeft + 1, preRight,
                map, pIndex + 1, inRight
            )
            return root
        }
    }
}