package boj._1463_make_it_one

class Solution {
    private fun makeItOne(target: Int): Int {
        val mem = Array<Int>(size = 1000001, init = { _ -> 0 })
        mem[1] = 0
        for (i in 2..target) {
            mem[i] = mem[i - 1] + 1
            if (i % 2 == 0) {
                mem[i] = mem[i].coerceAtMost(mem[i / 2] + 1)
            }
            if (i % 3 == 0) {
                mem[i] = mem[i].coerceAtMost(mem[i / 3] + 1)
            }
        }
        return mem[target]
    }

    fun runWithInput() {
        val n = readLine()!!.toInt()
        println(makeItOne(n))
    }
}