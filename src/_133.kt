class _133 {
    companion object {
        data class Node(val `val`: Int, var neighbors: List<Node?> = emptyList())

        fun cloneGraph(node: Node?): Node? {
            val mark = mutableMapOf<Int, Node>()
            return dfs(node, mark)
        }

        private fun dfs(node: Node?, mark: MutableMap<Int, Node>): Node? {
            if (node == null) return null
            if (mark.containsKey(node.`val`))
                return mark[node.`val`]
            val clone = Node(node.`val`)
            mark[node.`val`] = clone
            clone.neighbors = node.neighbors.map { dfs(it, mark) }
            return clone
        }
    }
}