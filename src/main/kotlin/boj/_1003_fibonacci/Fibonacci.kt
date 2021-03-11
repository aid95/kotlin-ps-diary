package boj._1003_fibonacci

import java.io.BufferedReader
import java.io.InputStreamReader

val mem = Array(41) { 0 }

class Solution {
    private fun fibonacci() {
        mem[0] = 0
        mem[1] = 1
        mem[2] = 1
        for (i in 3..40) {
            mem[i] = mem[i - 1] + mem[i - 2]
        }
    }

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        fibonacci()
        val t = readLine()!!.toInt()
        for (i in 0 until t) {
            val n = readLine()!!.toInt()
            if (n == 0) {
                println("1 0")
            } else {
                println("%d %d".format(mem[n - 1], mem[n]))
            }
        }
    }
}