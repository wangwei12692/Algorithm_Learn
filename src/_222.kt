class _222 {
    companion object {
        fun countNodes(root: TreeNode?): Int {
            if (root == null)
                return 0
            return 1 + countNodes(root.left) + countNodes(root.right)
        }

        //满二叉树
        fun countNodes2(root: TreeNode?): Int {
            if (root == null)
                return 0
            val left = level(root.left)
            val right = level(root.right)
            return if (left == right)
                countNodes2(root.right) + (1.shl(left))
            else
                countNodes2(root.left) + (1.shl(right))

        }

        fun level(root: TreeNode?): Int {
            if (root == null)
                return 0
            var node = root
            var level = 0
            while (node != null) {
                level++
                node = node.left
            }
            return level
        }
    }
}