package boj._9095_add_one_two_three

import java.util.*

class Solution {
    private fun addOneTwoThree(target: Int): Int {
        val mem = Array<Int>(size = 100001, init = { _ -> 0 })
        mem[1] = 1
        mem[2] = 2
        mem[3] = 4
        for (i in 4..target) {
            mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3]
        }
        return mem[target]
    }

    fun runWithInput() = with(Scanner(System.`in`)) {
        val t = nextInt()
        for (i in 0 until t) {
            val n = nextInt()
            println(addOneTwoThree(n))
        }
    }
}