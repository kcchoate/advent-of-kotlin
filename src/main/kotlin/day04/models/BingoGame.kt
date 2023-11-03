package day04.models

import java.util.*

// was his name-o
class BingoGame(input: String) {
    val numbers: Queue<Int>
    val boards: List<BingoBoard>

    init {
        val foo = input.split("\n\n")
        numbers = LinkedList(foo[0].split(',').map { it.toInt() })
        boards = foo.drop(1).map { BingoBoard(it) }
    }

    fun play(): Int {
        var lastNumber = 0

        while (!gameIsOver()) {
            lastNumber = playRound()
        }

        return lastNumber
    }

    fun getWinner(): Optional<BingoBoard> {
        val winningBoard: BingoBoard = boards.firstOrNull { it.isWinner() } ?: return Optional.empty()
        return Optional.of(winningBoard)
    }

    private fun gameIsOver(): Boolean {
        return boards.any { it.isWinner() } || numbers.isEmpty()
    }

    private fun playRound(): Int {
        val number = numbers.remove()
        boards.forEach { it.markBoard(number) }
        return number
    }
}
