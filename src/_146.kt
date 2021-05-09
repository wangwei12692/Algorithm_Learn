class _146 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lruCache = LRUCache(2)
            lruCache.put(1,1)
            lruCache.put(2,2)
            println(lruCache[1])
            lruCache.put(3,3)
            println(lruCache[2])
            lruCache.put(4,4)
            println(lruCache[1])
            println(lruCache[3])
            println(lruCache[4])
        }
    }

    class LRUCache(private val capacity: Int) {

        private val map = mutableMapOf<Int, Node>()
        private val head = Node(-1, -1)
        private val tail = Node(-1, -1)

        init {
            head.next = tail
            tail.prev = head
        }

        operator fun get(key: Int): Int {
            //返回
            //移到最前面
            val node = map[key]
            if (node == null) {
                return -1
            } else {
                deleteNode(node)
                addToHead(node)
                return node.value
            }
        }

        fun put(key: Int, value: Int) {
            if (map[key] != null) {
                val node = map[key]!!
                deleteNode(node)
                addToHead(node)
            } else {
                if (map.size == capacity) {
                    deleteNode(tail.prev!!)
                }
                val node = Node(key, value)
                addToHead(node)
            }
        }

        private fun addToHead(node: Node) {
            map[node.key] = node
            val next = head.next
            head.next = node
            node.prev = head
            node.next = next
            next!!.prev = node
        }

        private fun deleteNode(node: Node) {
            map.remove(tail.prev!!.value)
            val next = node.next
            val prev = node.prev
            prev!!.next = next
            next!!.prev = prev
        }

        private data class Node(
            val key: Int,
            val value: Int,
            var prev: Node? = null,
            var next: Node? = null
        )

    }

}