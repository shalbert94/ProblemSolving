package com.example.shalomhalbert.problemsolving.september12

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NumberComplement(val number: Int, val expected: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>> =
                listOf(
                        arrayOf(5, 2),
                        arrayOf(1, 0),
                        arrayOf(2, 1),
                        arrayOf(4, 3),
                        arrayOf(9, 6)
                )
    }

    @Test
    fun `Returns compliment integer`() {
        //Given an integer
        number
        //When calculating the compliment number
        val complement = findComplement(number)
        //Then the result should be as expected
        assertThat(complement).isEqualTo(expected)
    }

    fun findComplement(num: Int): Int {
        val string = Integer.toBinaryString(num)
        var complementString = ""

        for (char in string.toCharArray()) {
            when (char) {
                '0' -> complementString += "1"
                '1' -> complementString += "0"
            }
        }

        val result = Integer.parseInt(complementString, 2)

        return result
    }

    fun efficienFindComplement(num: Int): Int {
        return num.inv() and ((Integer.highestOneBit(num) shl 1) - 1)
    }

    fun solutionFindComplement(x: Int): Int {
        var x = x
        val length = Integer.toBinaryString(x).length
        for (i in 0 until length) {
            if (x and (1 shl i) == 0) {
                x = x or (1 shl i)
            } else {
                x = x and (1 shl i).inv()
            }
        }
        return x
    }

}
