package boj._13417_card_string

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine()!!.toInt()
        for (i in 0 until n) {
            readLine()
            val chars = readLine()!!.trim().split(" ").map { it.toInt() }
            val answer = chars[0]
            for (pos in 1 until chars.size) {
            }
        }
    }
}