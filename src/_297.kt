import java.util.*

class _297 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val codec = Codec()
            val node = codec.deserialize("[1,2,3,null,null,4,5,6,7]")
            println(codec.serialize(node))
        }
    }

    class Codec2 {
        fun serialize(root: TreeNode?): String {
            if (root == null) return "null"
            return "${root.`val`},${serialize(root.left)},${serialize(root.right)}"
        }

        fun deserialize(data: String): TreeNode? {
            val nums = data.split(",").map { it.trim().toIntOrNull() }
            if (nums.isEmpty()) return null
            return dfs(LinkedList(nums))
        }

        private fun dfs(queue: LinkedList<Int?>): TreeNode? {
            val value = queue.poll() ?: return null
            val root =  TreeNode(value)
            root.left =  dfs(queue)
            root.right =  dfs(queue)
            return root
        }

    }

    class Codec() {
        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            if (root == null)
                return "[]"
            val ans = mutableListOf<Int?>()
            val queue = LinkedList<TreeNode?>()
            queue.offer(root)
            while (queue.isNotEmpty()) {
                val top = queue.poll()
                if (top == null) {
                    ans.add(null)
                } else {
                    ans.add(top.`val`)
                    queue.offer(top.left)
                    queue.offer(top.right)
                }
            }
            return ans.joinToString(prefix = "[", postfix = "]")
        }

        // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? {
            val nums = data.substring(1, data.length - 1).split(",").map { it.trim().toIntOrNull() }
            if (nums.isEmpty()) return null
            val queue = LinkedList<TreeNode>()
            val root = TreeNode(nums[0]!!)
            queue.offer(root)
            var idx = 1
            while (queue.isNotEmpty() && idx < nums.size) {
                val node = queue.poll()
                if (nums[idx] != null) {
                    node.left = TreeNode(nums[idx]!!)
                    queue.offer(node.left)
                }
                idx++
                if (nums[idx] != null) {
                    node.right = TreeNode(nums[idx]!!)
                    queue.offer(node.right)
                }
                idx++
            }
            return root
        }


    }
}