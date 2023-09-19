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

    private data class Instruction(val direction: String, val distance: Int)

    private data class Result(val horizontal: Int, val depth: Int, val aim: Int = 0) {
        fun calculateFinalValue() = horizontal * depth
    }

    private data class Result2(val horizontal: Int, val depth: Int, val aim: Int = 0) {
        fun calculateFinalValue() = horizontal * depth

        fun process(instruction: Instruction): Result2 {
           return when (instruction.direction) {
                "up" -> Result2(this.horizontal, this.depth, this.aim - instruction.distance)
                "down" -> Result2(this.horizontal, this.depth, this.aim + instruction.distance )
                "forward" -> Result2(this.horizontal + instruction.distance, this.depth + this.aim * instruction.distance, this.aim)
                else -> throw IllegalArgumentException("Unknown direction: ${instruction.direction}")
            }
        }
    }

    fun navigate2(input: List<String>) =
        input.map { it.split(' ') }
            .map { Instruction(it[0], it[1].toInt()) }
            .fold(Result2(0, 0, 0)) { acc, instruction -> acc.process(instruction) }
            .calculateFinalValue()
}
