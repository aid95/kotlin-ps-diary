package boj._20937_rice_cake_soup

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        readLine()
        val arr = Array(50001) { 0 }
        val c = readLine()!!.trim().split(' ').map { it.toInt() }
        for (e in c) {
            arr[e] += 1
        }
        println(arr.maxOrNull())
    }
}