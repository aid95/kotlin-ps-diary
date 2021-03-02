package boj._13305_gas_station

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal

class Solution {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val n = readLine()!!.toInt()
        val distances = readLine()!!.trim().split(' ').map { it.toBigDecimal() }
        val stations = readLine()!!.trim().split(' ').map { it.toBigDecimal() }

        var curStation = 0
        var curDistance = 0
        var totalAmount = BigDecimal.ZERO
        for (stationNum in 0 until n - 1) {
            if (stations[stationNum] < stations[curStation]) {
                curStation = stationNum
            }
            totalAmount += distances[curDistance++] * stations[curStation]
        }
        println(totalAmount)
    }
}