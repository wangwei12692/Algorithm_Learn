class TreeNode @JvmOverloads constructor(@JvmField val `val`: Int, @JvmField var left: TreeNode? = null, @JvmField var right: TreeNode? = null)
data class Node(val `val`: Int, val children: List<Node>? = null)
data class ListNode(var `val`: Int, @JvmField var next: ListNode? = null)

class UnionFind(var count: Int) {
    private val parent = IntArray(count) { it }
    fun union(x: Int, y: Int): Boolean {
        val px = find(x)
        val py = find(y)
        if (px == py) return false
        parent[x] = py
        count--
        return true
    }

    fun find(x: Int): Int {
        val px = parent[x]
        if (x == px)
            return px
        return find(px)
    }
}

fun IntArray.toListNode(): ListNode? {
    val dummy = ListNode(-1)
    var root: ListNode? = dummy
    for (i in this) {
        root?.next = ListNode(i)
        root = root?.next
    }
    return dummy.next
}

fun ListNode?.toIntArray(): IntArray {
    if (this == null) return intArrayOf()
    val list = mutableListOf<Int>()
    var tmp = this
    while (tmp != null) {
        list.add(tmp.`val`)
        tmp = tmp.next
    }
    return list.toIntArray()
}
