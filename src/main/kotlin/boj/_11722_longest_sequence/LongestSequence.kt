package boj._11722_longest_sequence

import java.util.*

class Solution {
    private fun longestSequence(size: Int, arr: Array<Int>): Int {
        val mem = Array<Int>(size) { 0 }
        for (i in 0 until size) {
            mem[i] = 1
            for (j in 0 until i) {
                if (arr[i] < arr[j]) {
                    mem[i] = mem[i].coerceAtLeast(mem[j] + 1)
                }
            }
        }
        return mem.maxOrNull() ?: 0
    }

    fun runWithInput() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val arr = Array<Int>(n) { nextInt() }
        println(longestSequence(n, arr))
    }
}