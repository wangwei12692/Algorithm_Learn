class _223 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }


    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val rect1 = Rect(ax1, ay2, ax2, ay1)
        val rect2 = Rect(bx1, by2, bx2, by1)
        if (rect1.height + rect2.height >= Math.max(rect1.top, rect2.top) - Math.min(rect1.bottom, rect2.bottom)
                && rect1.width + rect2.width >= Math.max(rect1.right, rect2.right) - Math.min(rect1.left, rect2.left)
        ) {
            return rect1.area() + rect2.area()
        } else {
           return 1
        }
    }

    data class Rect(
            val left: Int,
            val right: Int,
            val top: Int,
            val bottom: Int
    )

    val Rect.width: Int
        get() = right - left
    val Rect.height: Int
        get() = top - bottom

    fun Rect.area(): Int {
        return (right - left) * (top - bottom)
    }
}