package day01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SolutionTests {
    private val sut = Solution()

    @Test
    fun singleIncrement_returns1() {
        val input = listOf(199, 200);

        val result = sut.getNumberOfDepthIncreases(input);

        assertEquals(1, result);
    }

    @Test
    fun singleDecrement_returns0() {
        val input = listOf(200, 199);

        val result = sut.getNumberOfDepthIncreases(input);

        assertEquals(0, result);
    }

    @Test
    fun equalDepths_returns0() {
        val input = listOf(200, 200);

        val result = sut.getNumberOfDepthIncreases(input);

        assertEquals(0, result);
    }

    @Test
    fun emptyInput_returns0() {
        val input = emptyList<Int>();

        val result = sut.getNumberOfDepthIncreases(input);

        assertEquals(0, result);
    }

    @Test
    fun exampleInput_returns7() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

        val result = sut.getNumberOfDepthIncreases(input);

        assertEquals(7, result);
    }

    @Test
    fun part1_returnsCorrectAnswer() {
        val result = sut.part1();

        assertEquals(1624, result);
    }
}
