package day02

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class SolutionTests {
    private val sut = Solution()

    @Test
    fun `given forward movement without depth change, we return 0`() {
        // arrange
        val input = listOf("forward 5")

        // act
        val result = sut.navigate(input)

        // assert
        assertEquals(0, result)
    }

    @Test
    fun `given downward movement without depth change, we return 0`() {
        // arrange
        val input = listOf("down 5")

        // act
        val result = sut.navigate(input)

        // assert
        assertEquals(0, result)
    }

    @Test
    fun `given upward movement without depth change, we return 0`() {
        // arrange
        val input = listOf("up 5")

        // act
        val result = sut.navigate(input)

        // assert
        assertEquals(0, result)
    }

    @Test
    fun `given 1 forward and 1 down, we return 1`() {
        // arrange
        val input = listOf("forward 1", "down 1")

        // act
        val result = sut.navigate(input)

        // assert
        assertEquals(1, result)
    }

    @Test
    fun `answer to part 1`() {
        val input = File("src/main/kotlin/day02/input.txt").readLines()

        val result = sut.navigate(input)

        assertEquals(1427868, result)
    }
}
