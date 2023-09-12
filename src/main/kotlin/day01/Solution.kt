package day01

import java.io.File

// https://adventofcode.com/2021/day/1
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

    fun getNumberOfWindowDepthIncreases(depths: List<Int>): Int {
        var total = 0;
        for (i in 0 until depths.size - 3) {
            if (depths[i] < depths[i + 3]) {
                total++;
            }
        }
        return total;
    }

    fun part1(): Int {
        val input = File("src/main/kotlin/day01/input.txt").readLines().map { it.toInt() }
        return getNumberOfDepthIncreases(input);
    }

    fun part2(): Int {
        val input = File("src/main/kotlin/day01/input.txt").readLines().map { it.toInt() }
        return getNumberOfWindowDepthIncreases(input);
    }
}
