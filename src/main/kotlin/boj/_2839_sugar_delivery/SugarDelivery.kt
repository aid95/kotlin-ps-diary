package boj._2839_sugar_delivery

import java.util.*

class Solution {
    private fun sugarDelivery(n: Int): Int {
        var num = n
        var ans = 0
        while (num >= 0) {
            if (num % 5 == 0) {
                ans += num / 5
                num %= 5
                break
            }
            num -= 3
            ans += 1
            if (num < 0) {
                return -1
            }
        }
        return ans
    }

    fun runWithInput() {
        val n = readLine()!!.toInt()
        println(sugarDelivery(n))
    }
}

class Solution2 {
    private fun sugarDelivery(n: Int): Int {
        val dp = Array<Int>(5001) { 0 }

        dp[1] = -1
        dp[2] = -1
        dp[3] = 1
        dp[4] = -1
        dp[5] = 1
        for (i in 6..n) {
            val lhs = dp[i - 3]
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
        println(sugarDelivery(n))
    }
}