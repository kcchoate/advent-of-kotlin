package day04.models

class BingoBoard(input: String) {
    private val board: Array<Array<BingoSpace>> = Array(5) { Array(5) { BingoSpace(0) } }

    init {
        val splitInput = input.split("\n")
        for (i in 0..4) {
            val splitLine = splitInput[i].split(" ").filter { it.isNotBlank() }

            for (j in 0..4) {
                board[i][j] = BingoSpace(splitLine[j].toInt())
            }
        }
    }

    fun markBoard(value: Int): Boolean {
        for (i in 0..4) {
            for (j in 0..4) {
                if (board[i][j].value == value) {
                    board[i][j].mark()
                    return true
                }
            }
        }

        return false
    }

    fun isWinner(): Boolean {
        if (board.any{ row -> row.all { it.isMarked } }) {
            return true
        }

        for (col in 0..4) {
            if (board.all { it[col].isMarked }) {
                return true
            }
        }

        return false
    }

    fun getScore(lastCalled: Int): Int {
       val boardSum = board
           .flatMap { it.asSequence() }
           .filterOut { it.isMarked }
           .sumOf { it.value }

       return boardSum * lastCalled
    }

    private fun <T> List<T>.filterOut(predicate: (T) -> Boolean): List<T> {
        return this.filterNot(predicate)
    }
}
