import java.util.*

class _1460 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
            if (target.size != arr.size)
                return false
            target.sort()
            arr.sort()
            return target.contentEquals(arr)
        }
    }
}