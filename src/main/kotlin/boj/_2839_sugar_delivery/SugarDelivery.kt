package boj._2839_sugar_delivery

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