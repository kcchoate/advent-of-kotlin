package day02

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class SolutionTests {
    private val sut = Solution()

    @Test
    fun `given example, we return the correct answer`() {
        // arrange
        val input = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")

        // act
        val result = sut.navigate2(input)

        // assert
        assertEquals(900, result)
    }

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

    @Test
    fun `answer to part 2`() {
        val input = File("src/main/kotlin/day02/input.txt").readLines()

        val result = sut.navigate2(input)

        assertEquals(1568138742, result)
    }
}
