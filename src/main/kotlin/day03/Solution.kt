package day03

class Solution {

    fun solve(items: List<String>): Int {
        val sums = countArray(items)

        val target = items.size / 2
        val gammaRate = count(sums) { if (it < target) 0 else 1 }
        val epsilonRate = count(sums) { if (it < target) 1 else 0 }

        return gammaRate * epsilonRate
    }

    private fun countArray(items: List<String>): IntArray {
        val sums = IntArray(items[0].length)
        for (item in items) {
            item.split("")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
                .forEachIndexed { idx, value -> sums[idx] += value }
        }
        return sums
    }

    private fun count(sums: IntArray, transform: (Int) -> Int): Int {
        val str = sums.map { transform(it) }.joinToString("")
        return str.toInt(2)
    }

    fun getOxygenGeneratorRating(input: List<String>): Int {
        return filter(input) { value, moreCommon -> value == moreCommon }
    }

    fun getCO2ScrubberRating(input: List<String>): Int {
        return filter(input) { value, moreCommon -> value != moreCommon }
    }

    private fun filter(input:List<String>, predicate: (Int, Int) -> Boolean): Int {
        val filtered = input.toMutableList();
        for(i in 0..<input[0].length) {
            val sums = countArray(filtered)
            filtered.retainAll { predicate.invoke(it[i].toString().toInt(), moreCommon(sums[i], filtered)) }
            if (filtered.size == 1) {
                break
            }
        }

        return filtered[0].toInt(2)
    }

    private fun moreCommon(value: Int, input: List<String>): Int {
        val target = input.size / 2.0

        return if (value >= target) 1 else 0
    }

    fun solve2(input: List<String>): Int {
        return getCO2ScrubberRating(input) * getOxygenGeneratorRating(input)
    }
}
