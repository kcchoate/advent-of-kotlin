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
}
