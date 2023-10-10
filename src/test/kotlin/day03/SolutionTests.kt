package day03

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class SolutionTests {
    @Test
    fun foo() {
        val input = listOf("1111", "0000", "1111")

        val result = Solution().solve(input)

        assertEquals(0, result)
    }

    @Test
    fun `part1 example`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val result = Solution().solve(input)

        assertEquals(198, result)
    }

    @Test
    fun `answer to part 1`() {
        val input = File("src/main/kotlin/day03/input.txt").readLines()

        val result =  Solution().solve(input)

        assertEquals(2954600, result)
    }

    @Test
    fun `get oxygen generator rating`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val result = Solution().getOxygenGeneratorRating(input)

        assertEquals(23, result)
    }

    @Test
    fun `get co2 scrubber rating`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val result = Solution().getCO2ScrubberRating(input)

        assertEquals(10, result)
    }

    @Test
    fun `part2 example`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val result = Solution().solve2(input)

        assertEquals(230, result)
    }

    @Test
    fun `answer to part 2`() {
        val input = File("src/main/kotlin/day03/input.txt").readLines()

        val result =  Solution().solve2(input)

        assertEquals(1662846, result)
    }
}
