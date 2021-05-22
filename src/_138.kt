class _138 {
    data class Node(val `val`: Int, val next: Node?, val random: Node? = null)

    companion object {
        fun copyRandomList(node: Node?): Node? {
            // old to new
            val mark = mutableMapOf<Node, Node?>()
            return dfs(node, mark)
        }

        private fun dfs(node: Node?, mark: MutableMap<Node, Node?>): Node? {
            if (node == null)
                return null
            if (mark[node] != null) {
                return mark[node]
            }
            val root = Node(node.`val`, dfs(node.next, mark), dfs(node.random, mark))
            mark[node] = root
            return root
        }
    }
}