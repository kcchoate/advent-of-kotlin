package day02

class Solution {
    fun navigate(input: List<String>) =
        input.map { it.split(' ') }
            .map { Instruction(it[0], it[1].toInt()) }
            .fold(Result(0, 0)) { acc, instruction ->
                when (instruction.direction) {
                    "up" -> Result(acc.horizontal, acc.depth - instruction.distance)
                    "down" -> Result(acc.horizontal, acc.depth + instruction.distance)
                    "forward" -> Result(acc.horizontal + instruction.distance, acc.depth)
                    else -> throw IllegalArgumentException("Unknown direction: ${instruction.direction}")
                }
            }
            .calculateFinalValue()

    private class Instruction(val direction: String, val distance: Int)

    private class Result(val horizontal: Int, val depth: Int) {
        fun calculateFinalValue() = horizontal * depth
    }
}
