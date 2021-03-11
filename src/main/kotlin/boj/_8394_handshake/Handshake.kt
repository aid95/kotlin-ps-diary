package boj._8394_handshake

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine()!!.toInt()
        val mem = Array(10000001) { 0 }
        mem[1] = 1
        mem[2] = 2
        mem[3] = 3
        for (i in 4..n) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 10
        }
        println(mem[n])
    }
}