import java.util.*

class Huffman<T> {
    data class Node<T>(val t: T?, val weight: Float, val left: Node<T>? = null, val right: Node<T>? = null)

    fun buildTree(nodes: List<Node<T>>): Node<T> {
        val pq = PriorityQueue<Node<T>>(compareBy { it.weight })
        pq.addAll(nodes)
        while (pq.size > 1) {
            val left = pq.poll()
            val right = pq.poll()
            pq.offer(Node(null, left.weight + right.weight, left, right))
        }
        return pq.poll()
    }
}