package boj._10996_draw_star_21

import java.util.*

class Solution {
    private fun drawStar(n: Int) {
        val m = n / 2
        var f = true
        for (i in 0 until n) {
            for (j in 0 until (n - m)) {
                print("*")
            }
            println();
            f = true
            for (j in 0 until (m)) {
                print("*")
            }
            println()
        }
    }

    fun runWithInput() = with(Scanner(System.`in`)) {
        val n = nextInt()
        drawStar(n)
    }
}