package boj._10757_add_two_big_numbers

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    fun runWithInput() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val numbers = readLine()!!.split(' ').map { it.toBigDecimal() }
        println(numbers.sumOf { it })
    }
}