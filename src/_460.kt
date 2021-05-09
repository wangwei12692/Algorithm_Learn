import java.util.*

class _460 {
    class LFUCache(val capacity: Int) {

        data class Node(
            val key: Int,
            val value: Int,
            var freq: Int = 1,
        )

        private val keyTable = mutableMapOf<Int, Node>()
        private val freqTable = mutableMapOf<Int, LinkedList<Node>>()
        private var minFreq = 0 //最少使用的频率

        fun get(key: Int): Int {
            if (capacity == 0) {
                return -1
            }
            if (!keyTable.containsKey(key))
                return -1
            val (_, value, freq) = keyTable[key]!!
            freqTable[freq]!!.removeLast()
            if (freqTable[freq]!!.size == 0) {
                freqTable.remove(freq)
                if (minFreq == freq)
                    minFreq += 1
            }
            val list = freqTable.getOrPut(freq + 1, { LinkedList() })
            list.add(0, Node(key, value, freq))
            keyTable[key]!!.freq += 1
            return value
        }


        fun put(key: Int, value: Int) {
            if (capacity == 0)
                return
            if (!keyTable.containsKey(key)) {
                if (keyTable.size == capacity) {
                    val node = freqTable[minFreq]!!.removeLast()
                    keyTable.remove(node.key)
                    if (freqTable[minFreq]!!.size == 0) {
                        freqTable.remove(minFreq)
                    }
                }
                val list = freqTable.getOrPut(1, { LinkedList() })
                list.add(0, Node(key, value))
                keyTable[key] = list.first
                minFreq = 1
            } else {
                val node = keyTable[key]!!
                freqTable[node.freq]!!.remove(node)
                if (freqTable[node.freq]!!.size == 0) {
                    freqTable.remove(node.freq)
                    if (minFreq == node.freq) {
                        minFreq += 1
                    }
                }

                val list = freqTable.getOrPut(node.freq + 1, { LinkedList() })
                list.add(0, Node(key, value, node.freq + 1))
                keyTable[key]!!.freq += 1
            }
        }

    }
}