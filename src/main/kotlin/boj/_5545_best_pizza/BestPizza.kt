package boj._5545_best_pizza

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    fun runWithInput() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine()!!.toInt()
        val ab = readLine()!!.split(' ').map { it.toInt() }
        val c = readLine()!!.toInt()
        val d = Array(n) { readLine()!!.toInt() }
        d.sortDescending()

        var num = 0
        var ans = c / (ab[0] + ab[1] * num++)
        var total = c
        for (e in d) {
            total += e
            ans = ans.coerceAtLeast(total / (ab[0] + ab[1] * num++))
        }
        println(ans)
    }
}