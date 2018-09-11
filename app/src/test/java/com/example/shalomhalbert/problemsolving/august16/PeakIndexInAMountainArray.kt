package com.example.shalomhalbert.problemsolving.august16

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class PeakIndexInAMountainArray(val mountain: List<Int>, val output: List<Int>){

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<List<Int>>> =
                listOf(
                        arrayOf(
                                listOf(0,1,0),
                                listOf(1)
                        ),
                        arrayOf(
                                listOf(0,2,1,0),
                                listOf(1)
                        )
                )
    }

    @Test
    fun `Correct peak found`() {
        //Given an Array of integers
        mountain

        //When trying to find the peak's index
        val peak = peakIndexInMountainArray(mountain.toIntArray())

        //Then the correct index is found
        assertThat(peak).isEqualTo(output[0])
    }

    fun peakIndexInMountainArray(A: IntArray): Int {
        for (index in (1..A.size - 2)) {
            if (A[index] > A[index - 1] && A[index] > A[index + 1]) return index
        }
        throw IllegalArgumentException("$A is not a mountain")
    }

    fun peakIndexInMountainArrayBetter(A: IntArray): Int {

        var leftIndex = 0
        var rightIndex = A.size - 1

        while(leftIndex <= rightIndex) {
            val middleIndex = (leftIndex + rightIndex) / 2

            when {
//                A[middleIndex] < A[middleIndex - 1] -> rightIndex = middleIndex - 1
//                A[middleIndex] < A[middleIndex + 1]
            }
        }

        for (index in (1..A.size - 2)) {
            if (A[index] > A[index - 1] && A[index] > A[index + 1]) return index
        }
        throw IllegalArgumentException("$A is not a mountain")
    }

}