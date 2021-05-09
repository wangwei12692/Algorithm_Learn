class jz27 {
    companion object{
        fun mirrorTree(root: TreeNode?): TreeNode? {
            if (root == null) return null
            val left = root.left
            root.left = mirrorTree(root.right)
            root.right = mirrorTree(left)
            return root
        }
    }
}