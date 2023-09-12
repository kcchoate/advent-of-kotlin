package day01

import java.io.File

// https://adventofcode.com/2021/day/1
class Solution {

    fun getNumberOfDepthIncreases(depths: List<Int>): Int = countWindowIncreases(depths, 2)

    fun getNumberOfWindowDepthIncreases(depths: List<Int>): Int = countWindowIncreases(depths, 4)

    private fun countWindowIncreases(depths: List<Int>, windowSize: Int) =
        depths.windowed(windowSize).count { it.first() < it.last() }

    fun part1(): Int {
        val input = File("src/main/kotlin/day01/input.txt").readLines().map { it.toInt() }
        return getNumberOfDepthIncreases(input);
    }

    fun part2(): Int {
        val input = File("src/main/kotlin/day01/input.txt").readLines().map { it.toInt() }
        return getNumberOfWindowDepthIncreases(input);
    }
}
