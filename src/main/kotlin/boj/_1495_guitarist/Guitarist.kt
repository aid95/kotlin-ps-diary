package boj._1495_guitarist

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var dp: Array<Array<Int>>
lateinit var volumes: List<Int>

class Solution {
    private fun solve(pos: Int, volumeNum: Int, currentVolume: Int, maxVolume: Int): Int {
        if (currentVolume > maxVolume || currentVolume < 0) {
            return Int.MIN_VALUE
        }
        if (pos == volumeNum) {
            dp[pos][currentVolume] = currentVolume
            return dp[pos][currentVolume]
        }
        if (dp[pos][currentVolume] != -1) {
            return dp[pos][currentVolume]
        }
        dp[pos][currentVolume] =
            solve(pos + 1, volumeNum, currentVolume + volumes[pos], maxVolume).coerceAtLeast(
                solve(pos + 1, volumeNum, currentVolume - volumes[pos], maxVolume)
            )
        return dp[pos][currentVolume]
    }

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (_n, _s, _m) = readLine()!!.trim().split(' ').map { it.toInt() }
        volumes = readLine()!!.trim().split(' ').map { it.toInt() }
        dp = Array(101) { Array(1001) { -1 } }

        val result = solve(0, _n, _s, _m)
        println(
            when (result) {
                Int.MIN_VALUE -> -1
                else -> result
            }
        )
    }
}