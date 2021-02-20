package boj._1010_bridge_laying

import java.io.BufferedReader
import java.io.InputStreamReader

val mem = Array<Array<Int>>(31) { Array<Int>(31) { 0 } }

class Solution {
    private fun bridgeLaying(n: Int, m: Int): Int {
        for (i in 1..m) {
            mem[1][i] = i
        }
        for (i in 2..n) {
            for (j in 1 until m) {
                if (n > m) {
                    continue
                }
                mem[i][j + 1] = if (n == m) {
                    1
                } else {
                    mem[i - 1][j] + mem[i][j]
                }

            }
        }
        return mem[n][m]
    }

    fun runWithInput() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine().toInt()
        for (i in 0 until n) {
            val arr = readLine().split(" ").map { it.toInt() }
            println(bridgeLaying(arr[0], arr[1]))
        }
    }
}