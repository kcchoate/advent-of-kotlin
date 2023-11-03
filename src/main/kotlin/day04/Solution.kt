package day04

import day04.models.BingoGame
import java.io.File

class Solution {
    val input = File("src/main/kotlin/day04/input.txt").readText()

    fun solve(): Int {
        val game = BingoGame(input)
        val lastNumber = game.play()
        val winner = game.getWinner().get()

        return winner.getScore(lastNumber)
    }
}
