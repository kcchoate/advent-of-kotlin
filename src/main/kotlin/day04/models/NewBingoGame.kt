package day04.models

import java.util.*

class NewBingoGame(input: String) {
    val numbers: Queue<Int>
    val boards: List<BingoBoard>

    private var lastWinner: BingoBoard? = null

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

    fun getWinner(): Optional<BingoBoard> = Optional.ofNullable(boards.firstOrNull { it.isWinner() })

    fun getLastWinner(): Optional<BingoBoard> = Optional.ofNullable(lastWinner)

    private fun gameIsOver(): Boolean {
        return boards.all { it.isWinner() } || numbers.isEmpty()
    }

    private fun playRound(): Int {
        val number = numbers.remove()
        boards
            .filterNot { it.isWinner() }
            .forEach {
                it.markBoard(number)
                if (it.isWinner()) {
                    lastWinner = it
                }
            }
        return number
    }
}