package com.example.shalomhalbert.problemsolving.september2

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.math.min

@RunWith(Parameterized::class)
class ArrayPartition1(val input: List<Int>, val output: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> =
                listOf(
                        arrayOf(
                                listOf(1, 4, 3, 2),
                                4
                        )
                )
    }

    @Test
    fun `calculates array pair sums`() {
        //Given an Array of integers
        input

        //When they are paired and the minimum values are added
        val result = arrayPairSum(input.toIntArray())

        //Then the sum of minimum values from the pairs is as expected
        assertThat(result).isEqualTo(output)
    }

    private fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var pairMinSum = 0
        for (a in 0..(nums.size - 2) step 2) pairMinSum += min(nums[a], nums[a+1])
        return pairMinSum
    }
}