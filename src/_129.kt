class _129 {
    companion object{
        fun sumNumbers(root: TreeNode?): Int {
            return dfs(root,0)
        }

        private fun dfs(root:TreeNode?,sum:Int):Int{
            if(root == null) return 0
            if(root.left == null && root.right == null)
                return sum *10+ root.`val`
            return dfs(root.left,sum*10 +root.`val`) + dfs(root.right,sum*10+root.`val`)
        }
    }
}