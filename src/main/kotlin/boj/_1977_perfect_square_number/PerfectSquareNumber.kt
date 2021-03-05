package boj._1977_perfect_square_number

import java.io.BufferedReader
import java.io.InputStreamReader

val map = Array(10001) { false }

class Solution {
    private fun init() {
        var n = 1.0
        while (true) {
            val r = Math.pow(n, 2.0).toInt()
            if (r > 10000) {
                break
            }
            map[r] = true
            n += 1
        }
    }

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val m = readLine()!!.toInt()
        val n = readLine()!!.toInt()
        init()

        var total = 0
        var min = -1
        for (i in m..n) {
            if (map[i]) {
                total += i
                if (min == -1) {
                    min = i
                }
            }
        }
        if (total != 0) println(total)
        println(min)
    }
}