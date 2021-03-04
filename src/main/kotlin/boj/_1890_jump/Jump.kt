package boj._1890_jump

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

class Solution {
    private fun solve(x: Int, y: Int, size: Int, map: Array<List<Int>>, dp: Array<Array<BigInteger>>): BigInteger {
        if (x < size && y < size) {
            if (x == size - 1 && y == size - 1) {
                return BigInteger.ONE
            } else if (dp[y][x] == -BigInteger.ONE) {
                dp[y][x] = BigInteger.ZERO
                val move = map[y][x]
                dp[y][x] += solve(x + move, y, size, map, dp)
                dp[y][x] += solve(x, y + move, size, map, dp)
            }
            return dp[y][x]
        }
        return BigInteger.ZERO
    }

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine()!!.toInt()
        val map = Array(n) { readLine()!!.trim().split(' ').map { it.toInt() } }
        val dp = Array(n) { Array(n) { -BigInteger.ONE } }
        println(solve(0, 0, n, map, dp))
    }
}