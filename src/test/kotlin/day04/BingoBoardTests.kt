package day04

import day04.models.BingoBoard
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BingoBoardTests {
    private lateinit var sut: BingoBoard
    @BeforeEach
    fun setup() {

        sut = BingoBoard("""
        22 13 17 11  0
         8  2 23  4 24
        21  9 14 16  7
         6 10  3 18  5
         1 12 20 15 19
        """.trimIndent())
    }

    @Test
    fun `it should not be a winner if nothing is marked`() {
        assertFalse { sut.isWinner() }
    }

    @Test
    fun `it should be a winner if the first row is marked`() {
        sut.markBoard(22)
        sut.markBoard(13)
        sut.markBoard(17)
        sut.markBoard(11)
        sut.markBoard(0)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the second row is marked`() {
        sut.markBoard(8)
        sut.markBoard(2)
        sut.markBoard(23)
        sut.markBoard(4)
        sut.markBoard(24)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the third row is marked`() {
        sut.markBoard(21)
        sut.markBoard(9)
        sut.markBoard(14)
        sut.markBoard(16)
        sut.markBoard(7)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the fourth row is marked`() {
        sut.markBoard(6)
        sut.markBoard(10)
        sut.markBoard(3)
        sut.markBoard(18)
        sut.markBoard(5)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the fifth row is marked`() {
        sut.markBoard(1)
        sut.markBoard(12)
        sut.markBoard(20)
        sut.markBoard(15)
        sut.markBoard(19)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the first column is marked`() {
        sut.markBoard(22)
        sut.markBoard(8)
        sut.markBoard(21)
        sut.markBoard(6)
        sut.markBoard(1)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the second column is marked`() {
        sut.markBoard(13)
        sut.markBoard(2)
        sut.markBoard(9)
        sut.markBoard(10)
        sut.markBoard(12)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the third column is marked`() {
        sut.markBoard(17)
        sut.markBoard(23)
        sut.markBoard(14)
        sut.markBoard(3)
        sut.markBoard(20)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the fourth column is marked`() {
        sut.markBoard(11)
        sut.markBoard(4)
        sut.markBoard(16)
        sut.markBoard(18)
        sut.markBoard(15)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should be a winner if the fifth column is marked`() {
        sut.markBoard(0)
        sut.markBoard(24)
        sut.markBoard(7)
        sut.markBoard(5)
        sut.markBoard(19)

        assertTrue(sut.isWinner())
    }

    @Test
    fun `it should return the sum of unmarked numbers multiplied by the last called number`() {
        val lastCalled = 22

        sut.markBoard(0)
        sut.markBoard(13)
        sut.markBoard(17)
        sut.markBoard(11)
        sut.markBoard(lastCalled)

        val score = sut.getScore(lastCalled)

        assertEquals(5214, score)
    }

    @Test
    fun `it should return a 0 score if the last number was 0`() {
        val lastCalled = 0

        sut.markBoard(22)
        sut.markBoard(13)
        sut.markBoard(17)
        sut.markBoard(11)
        sut.markBoard(lastCalled)

        val score = sut.getScore(lastCalled)

        assertEquals(0, score)
    }
}