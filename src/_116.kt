class _116 {
    private data class Node(
        val left: Node?,
        val right: Node?,
        var next: Node?
    )

    private fun connect(root: Node?): Node? {
        val rightNodes = mutableMapOf<Int, Node>()
        dfs(root, 0, rightNodes)
        return root
    }

    private fun dfs(root: Node?, k: Int, rightNodes: MutableMap<Int, Node>) {
        if (root == null)
            return
        root.next = rightNodes[k]
        rightNodes[k] = root
        dfs(root.right, k + 1, rightNodes)
        dfs(root.left, k + 1, rightNodes)
    }
}