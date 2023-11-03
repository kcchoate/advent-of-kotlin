package day04

import day04.models.BingoGame
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class BingoGameTests {
    @Test
    fun `when input does not end game, game ends when numbers are gone`() {
        val sut = BingoGame("""
        22,13,17,11
        
        22 13 17 11  0
         8  2 23  4 24
        21  9 14 16  7
         6 10  3 18  5
         1 12 20 15 19
        """.trimIndent())

        sut.play()

        assertTrue(sut.getWinner().isEmpty)
    }
}
