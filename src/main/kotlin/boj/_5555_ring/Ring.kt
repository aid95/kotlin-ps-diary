package boj._5555_ring

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Solution {
    private fun rotateCompare(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        // 0 1 2 3 4 5
        for (i in s2.indices) {
            var isSame = true
            // 0 1 2
            for (j in s1.indices) {
                if (s1[j] != s2[(i + j) % s2.length]) {
                    isSame = false
                    break
                }
            }
            if (isSame) {
                return true
            }
        }
        return false
    }

    fun runWithInput() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val s = readLine()!!
        val n = readLine()!!.toInt()
        val v = Vector<String>()
        for (i in 0 until n) {
            v.add(readLine()!!)
        }
        var ans = 0
        for (i in 0 until v.size) {
            if (rotateCompare(s, v[i])) {
                ans++
            }
        }
        println(ans)
    }
}