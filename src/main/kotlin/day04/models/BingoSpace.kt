package day04.models

class BingoSpace(val value: Int) {
    var isMarked: Boolean = false

    fun mark() {
        isMarked = true
    }
}
