class _990 {
    companion object {
        fun equationsPossible(equations: Array<String>): Boolean {
            val n = equations.size * 2
            val uf = UnionFind(26)
            val ops = equations.map { it.toCharArray() }
            for ((a, op, _, b) in ops) {
                if (op == '=') {
                    uf.union(a - 'a', b - 'a')
                } else {
                    if (uf.find(a-'a') == uf.find(b-'a'))
                        return false
                }
            }
            return true
        }
    }

}