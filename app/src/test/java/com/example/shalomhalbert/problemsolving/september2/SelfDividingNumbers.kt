package com.example.shalomhalbert.problemsolving.september2

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SelfDividingNumbers(val left: Int, val right: Int, val output: List<Int>) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> =
                listOf(
                        arrayOf(
                                1,
                                22,
                                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)
                        )
                )
    }

    @Test
    fun `Find self-dividing numbers`() {
        //Given a left and right bound for a range of numbers
        left
        right

        //When iterating through every number between them (inclusive)
        val selfDividingNumbers = getSelfDividingNumbers(left, right)

        //Then return an list of integers that are self dividing
        assertThat(selfDividingNumbers.size).isEqualTo(output.size)
        for (index in 0..(selfDividingNumbers.size-1)) assertThat(selfDividingNumbers[index]).isEqualTo(output[index])
    }

    fun getSelfDividingNumbers(left: Int, right: Int): List<Int> {
        var selfDividingNumbers = mutableListOf<Int>()

        when {
            left < 1 -> throw IllegalArgumentException("left ($left) must be >= 1")
            left > right -> throw IllegalArgumentException("left ($left) is greater than right ($right)")
            right > 10000 -> throw IllegalArgumentException("right ($right) must be <= 10,000")
        }

        for (number in left..right) {
            var remainingDigits = number
            while (remainingDigits > 0) {
                val currentDigit = remainingDigits % 10 //Get last digit in digits

                if ( currentDigit == 0 || number % currentDigit != 0 ) break
                else {
                    remainingDigits /= 10
                    if (remainingDigits == 0) selfDividingNumbers.add(number)
                }
            }
        }

        return selfDividingNumbers
    }

}