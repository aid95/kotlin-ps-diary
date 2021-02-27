package boj._5534_signboard

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Solution {
    private fun comp(s1: String, s2: String): Boolean {
        for (base in s2.indices) {
            for (gap in 1 until (s2.length - base)) {
                var pos1 = 0
                var pos2 = 0
                var isSame = true
                while (isSame && pos1 < s1.length && (base + pos2) < s2.length) {
                    if (s1[pos1] == s2[base + pos2]) {
                        pos1 += 1
                        pos2 += gap
                    } else {
                        isSame = false
                    }
                }
                if (isSame && pos1 == s1.length) return true
            }
        }
        return false
    }

    fun runWithInput() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine()!!.toInt()
        val s = readLine()!!
        val v = Vector<String>()
        for (i in 0 until n) {
            v.add(readLine()!!)
        }
        var ans = 0
        for (i in 0 until n) {
            if (comp(s, v[i])) ans++
        }
        println(ans)
    }
}