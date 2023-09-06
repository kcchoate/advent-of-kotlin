package day01

import java.io.File

class Solution {

    fun getNumberOfDepthIncreases(depths: List<Int>): Int {
        var total = 0;
        for (i in 0 until depths.size - 1) {
            if (depths[i] < depths[i + 1]) {
                total++;
            }
        }
        return total;
    }

    fun part1(): Int {
        val input = File("src/main/kotlin/day01/input.txt").readLines().map { it.toInt() }
        return getNumberOfDepthIncreases(input);
    }
}
