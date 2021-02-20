package boj._14916_change

import java.util.*

class Solution {
    private fun change(n: Int): Int {
        val dp = Array<Int>(100001) { 0 }

        dp[1] = -1
        dp[2] = 1
        dp[3] = -1
        dp[4] = 2
        dp[5] = 1
        for (i in 6..n) {
            val lhs = dp[i - 2]
            val rhs = dp[i - 5]
            if (lhs == -1 || rhs == -1) {
                if (lhs == rhs)
                    dp[i] = -1
                else
                    dp[i] = lhs.coerceAtLeast(rhs) + 1
            } else {
                dp[i] = lhs.coerceAtMost(rhs) + 1
            }
        }
        return dp[n]
    }

    fun runWithInput() = with(Scanner(System.`in`)) {
        val n = nextInt()
        println(change(n))
    }
}