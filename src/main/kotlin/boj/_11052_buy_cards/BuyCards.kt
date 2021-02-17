package boj._11052_buy_cards

import java.util.*

class Solution {
    private fun buyCard(target: Array<Int>, n: Int): Int {
        val mem = Array<Int>(n + 1) { 0 }
        /*
        card
        (1) = target[1]
        (2) = max(target[1] + target[1], target[2])
        (3) = max(
            target[1] + target[1] + target[1],
            target[2] + target[1],
            target[3]
            )
            !important =>
                target[1] + target[1] + target[1],
                target[2] + target[1],
                ==equal==
                (2) + target[1]
         */
        for (i in 1..n) {
            for (j in 1..i) {
                mem[i] = mem[i].coerceAtLeast((mem[i - j] + target[j]))
            }
        }
        return mem[n]
    }

    fun runWithInput() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val prices = Array<Int>(size = n + 1, init = { i: Int ->
            if (i == 0) {
                0
            } else {
                nextInt()
            }
        })
        println(buyCard(prices, n))
    }
}