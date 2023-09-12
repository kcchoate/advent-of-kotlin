package day01

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
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

    @Test
    fun `part2 when first window is less than second window then we return 1`() {
        val input = listOf(1, 2, 3, 4);

        val result = sut.getNumberOfWindowDepthIncreases(input);

        assertEquals(1, result);
    }

    @Test
    fun `part2 when first window is equal to second window then we return 0`() {
        val input = listOf(2, 2, 2, 2);

        val result = sut.getNumberOfWindowDepthIncreases(input);

        assertEquals(0, result);
    }

    @Test
    fun `part2 when first window is greater than second window then we return 0`() {
        val input = listOf(4, 3, 2, 1);

        val result = sut.getNumberOfWindowDepthIncreases(input);

        assertEquals(0, result);
    }

    @Test
    fun `part2 when input is empty then we return 0`() {
        val input = emptyList<Int>();

        val result = sut.getNumberOfWindowDepthIncreases(input);

        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("tooShortLists")
    fun `part2 when input is too short then we return 0`() {
        val input = listOf(1);

        val result = sut.getNumberOfWindowDepthIncreases(input);

        assertEquals(0, result);
    }

    @Test
    fun `part 2 returns correct value`() {
        val result = sut.part2();

        assertEquals(1653, result);
    }

    companion object {
        @JvmStatic
        private fun tooShortLists(): Stream<List<Int>> {
            return Stream.of(
                listOf(1),
                listOf(1, 2),
                listOf(1, 2, 3)
            );
        }
    }
}
