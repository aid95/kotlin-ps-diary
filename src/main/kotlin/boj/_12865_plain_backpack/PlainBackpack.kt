package boj._12865_plain_backpack

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    private fun plainBackpack(goodsNum: Int, backpackSize: Int, goodsArray: Array<Array<Int>>): Int {
        val mem = Array(goodsNum + 1) { Array(backpackSize + 1) { 0 } }
        for (i in 1..goodsNum) {
            for (j in 1..backpackSize) {
                if (goodsArray[i][0] <= j) {
                    mem[i][j] = mem[i - 1][j].coerceAtLeast(mem[i - 1][j - goodsArray[i][0]] + goodsArray[i][1])
                } else {
                    mem[i][j] = mem[i - 1][j]
                }
            }
        }
        return mem[goodsNum][backpackSize]
    }

    fun runWithInput() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val nk = readLine().split(" ").map { it.toInt() }
        val goods = Array(nk[0] + 1) { Array<Int>(2) { 0 } }
        for (i in 1..nk[0]) {
            val nw = readLine().split(" ").map { it.toInt() }
            goods[i][0] = nw[0]
            goods[i][1] = nw[1]
        }
        println(plainBackpack(nk[0], nk[1], goods))
    }
}