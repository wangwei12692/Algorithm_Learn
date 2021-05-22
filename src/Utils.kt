class TreeNode @JvmOverloads constructor(
    @JvmField var `val`: Int,
    @JvmField var left: TreeNode? = null,
    @JvmField var right: TreeNode? = null
)

data class Node(val `val`: Int, val children: List<Node>? = null)
data class ListNode(var `val`: Int, @JvmField var next: ListNode? = null)

class Trie {
    class TrieNode() {
        var isEnd = false
        var word: String = ""
        val next = Array<TrieNode?>(26) { null }
        operator fun get(char: Char): TrieNode? {
            return next[char - 'a']
        }

        operator fun set(char: Char, node: TrieNode) {
            next[char - 'a'] = node
        }
    }

    val root = TrieNode()

    fun insert(word: String) {
        var node: TrieNode = root
        for (c in word) {
            if (node[c] == null) {
                node[c] = TrieNode()
            }
            node = node[c]!!
        }
        node.isEnd = true
        node.word = word
    }

    fun searchPrefix(prefix: String): TrieNode? {
        var node = root
        for (c in prefix) {
            if (node[c] == null)
                return null
            node = node[c]!!
        }
        return node
    }
}

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
