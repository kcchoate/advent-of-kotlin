package day04.models

// was his name-o
class BingoGame(input: String) {
    val numbers: List<Int>
    val boards: List<BingoBoard>

    init {
        val foo = input.split("\n\n")
        numbers = foo[0].split(',').map { it.toInt() }
        boards = foo.drop(1).map { BingoBoard(it) }
    }
}
