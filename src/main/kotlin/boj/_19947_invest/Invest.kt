package boj._19947_invest

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var ans = 0F
val interest = Stack<Float>()

class Solution {
    private fun invest(h: Int, y: Int) {
        if (y == 0) {
            var result = h.toFloat()
            for (i in interest) {
                result += (result * i).toInt().toFloat()
            }
            ans = ans.coerceAtLeast(result)
        } else {
            if (y - 1 >= 0) {
                interest.push(0.05F)
                invest(h, y - 1)
            }
            if (y - 3 >= 0) {
                interest.push(0.20F)
                invest(h, y - 3)
            }
            if (y - 5 >= 0) {
                interest.push(0.35F)
                invest(h, y - 5)
            }
        }
        if (interest.size != 0)
            interest.pop()
    }

    fun runWithInput() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val inputData = readLine()!!.split(' ').map { it.toInt() }
        invest(inputData[0], inputData[1])
        println(ans.toInt())
    }

    fun correct(h: Int, y: Int): Int {
        val arr = Array<Int>(y) { 0 }
        arr[0] = h
        for (i in 1..y) {
            arr[i] = (arr[i - 1] * 1.05).toInt()
            if (i - 3 >= 0)
                arr[i] = (arr[i - 3] * 1.20F).coerceAtLeast(arr[i].toFloat()).toInt()
            if (i - 5 >= 0)
                arr[i] = (arr[i - 5] * 1.35F).coerceAtLeast(arr[i].toFloat()).toInt()
        }
        return arr[y]
    }
}