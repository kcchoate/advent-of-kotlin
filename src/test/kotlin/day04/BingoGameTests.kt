package day04

import day04.models.BingoGame
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
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

    @Test
    fun `when input finishes game board is returned`() {
        val sut = BingoGame("""
            22,13,17,11,0
            
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19
            """.trimIndent())

        sut.play()

        val winner = sut.getWinner()

        assertTrue(winner.isPresent)
        assertEquals(winner.get(), sut.boards[0])
    }

    @Test
    fun `when input finishes second game board is returned`() {
        val sut = BingoGame("""
            22,13,17,11,1
            
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19

            22 13 17 11  1
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19
            """.trimIndent())

        sut.play()

        val winner = sut.getWinner()

        assertTrue(winner.isPresent)
        assertEquals(winner.get(), sut.boards[1])
    }
    @Test
    fun `Bingo Boards Are Parsed Correctly`() {
        // Arrange
        val input = """
        7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

        22 13 17 11  0
         8  2 23  4 24
        21  9 14 16  7
         6 10  3 18  5
         1 12 20 15 19
        
         3 15  0  2 22
         9 18 13 17  5
        19  8  7 25 23
        20 11 10 24  4
        14 21 16 12  6
        
        14 21 17 24  4
        10 16 15  9 19
        18  8 23 26 20
        22 11 13  6  5
         2  0 12  3  7
        """.trimIndent()

        // Act
        val result = BingoGame(input)

        // Assert
        assertEquals(27, result.numbers.size)
        assertEquals(3, result.boards.size)
        assertTrue(result.boards[0].markBoard(22))
        assertTrue(result.boards[1].markBoard(7))
        assertTrue(result.boards[2].markBoard(7))
        assertFalse(result.boards[0].markBoard(69))
        assertFalse(result.boards[1].markBoard(69))
        assertFalse(result.boards[2].markBoard(69))
    }
}
