package day04

import day04.models.BingoGame
import day04.models.NewBingoGame
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.*

class SolutionTests {
    companion object {
        val InputFile = File("src/main/kotlin/day04/input.txt").readText()
    }

    @Test
    fun `Solve Part 1 Example`() {
        val sut = BingoGame("""
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
        """.trimIndent())

        val lastNumber = sut.play()
        val winner = sut.getWinner()

        assertTrue(winner.isPresent)
        assertEquals(4512, winner.get().getScore(lastNumber))
    }

    @Test
    fun `Solve Part 1`() {
        val solution = Solution()
        val actual = solution.solve()

        assertEquals(64084, actual)
    }

    @Test
    fun `Solve example part 2`() {
        val sut = NewBingoGame("""
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
        """.trimIndent())

        val lastNumber = sut.play()
        val winner = sut.getLastWinner()

        assertTrue(winner.isPresent)
        assertEquals(1924, winner.get().getScore(lastNumber))
    }

    @Test
    fun `Solve part 2`() {
        val sut = NewBingoGame(InputFile)
        val lastNumber = sut.play()
        val winner = sut.getLastWinner()

        assertTrue(winner.isPresent)
        assertEquals(12833, winner.get().getScore(lastNumber))
    }
}
