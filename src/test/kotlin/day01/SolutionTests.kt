package day01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SolutionTests {
    private val sut = Solution()

    @Test
    fun exampleInput_returns7() {
        val input = """199
200
208
210
200
207
240
269
260
263"""

        val result = sut.getNumberOfDepthIncreases();

        assertEquals(7, result);
    }
}