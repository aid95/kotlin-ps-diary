package boj._1260_dfs_and_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Solution {
    private fun dfs(startNode: Int, map: Array<Array<Boolean>>, check: Array<Boolean>) {
        check[startNode] = true
        print("$startNode ")
        for (i in map[startNode].indices) {
            if (!check[i] && map[startNode][i]) {
                dfs(i, map, check)
            }
        }
    }

    private fun bfs(startNode: Int, map: Array<Array<Boolean>>, check: Array<Boolean>) {
        val q: Queue<Int> = LinkedList<Int>()
        q.add(startNode)
        check[startNode] = true
        while (q.isNotEmpty()) {
            val cur = q.first()
            q.poll()
            print("$cur ")
            for (i in map[cur].indices) {
                if (!check[i] && map[cur][i]) {
                    check[i] = true
                    q.add(i)
                }
            }
        }
    }

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val (n, m, v) = readLine()!!.trim().split(" ").map { it.toInt() }
        val l = Array(1001) { Array(1001) { false } }
        for (i in 0 until m) {
            val (n1, n2) = readLine()!!.trim().split(" ").map { it.toInt() }
            l[n1][n2] = true
            l[n2][n1] = true
        }
        dfs(v, l, Array(1001) { false })
        println()
        bfs(v, l, Array(1001) { false })
    }
}