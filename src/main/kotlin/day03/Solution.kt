package day03

class Solution {
    fun solve(items: List<String>): Int {
        var sums = IntArray(items[0].length)

        for (i in items.indices) {
            val item = items[i]
            for (k in item.indices) {
                sums[k] += item[k].toString().toInt()
            }
        }

        val target = items.size / 2

        val gammaString = sums.map { if (it < target) 0 else 1 }.joinToString("")
        val epsilonString = sums.map { if (it < target) 1 else 0 }.joinToString("")

        val gammaRate = gammaString.toInt(2)
        val epsilonRate = epsilonString.toInt(2)

        return gammaRate * epsilonRate
    }
}
