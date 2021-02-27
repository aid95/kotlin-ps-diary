package boj._14606_pizza_small

import java.util.*

class Solution {
    private fun pizzaSmall(n: Int): Int {
        if (n == 1) return 0
        if (n == 2) return 1
        val m = n - 2
        return (m * 2) + pizzaSmall(m) + pizzaSmall(2)
    }

    fun runWithInput() = with(Scanner(System.`in`)) {
        val n = nextInt()
        println(pizzaSmall(n))
    }
}