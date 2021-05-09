class _114 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

        }
        var pre: TreeNode? = null
        fun flatten(root: TreeNode?): Unit {
            if (root == null)
                return
            if (pre == null)
                pre = root
            else {
                pre!!.right = root
                pre!!.left = null
                root.left = null
                pre = root
            }
            flatten(root.left)
            flatten(root.right)
        }
    }
}