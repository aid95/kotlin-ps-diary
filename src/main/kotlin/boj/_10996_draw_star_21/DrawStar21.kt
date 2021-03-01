package boj._10996_draw_star_21

import java.util.*

class Solution {
    private fun drawStar(n: Int) {
        val m = n / 2
        var c = 0
        var f = true

        for (i in 0 until n) {
            c = 0
            f = true
            while (c != (n - m)) {
                if (f) {
                    print("*")
                    c++
                } else {
                    print(" ")
                }
                f = !f
            }
            println()

            c = 0
            f = true
            while (c != m) {
                if (f) {
                    print(" ")
                } else {
                    print("*")
                    c++
                }
                f = !f
            }
            println()
        }
    }

    fun runWithInput() = with(Scanner(System.`in`)) {
        val n = nextInt()
        drawStar(n)
    }
}