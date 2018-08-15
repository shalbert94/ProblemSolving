package com.example.shalomhalbert.problemsolving.august14

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class FlippingAnImage(val image: List<IntArray>, val flippedImage: List<IntArray>) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<List<IntArray>>> =
                listOf(
                        arrayOf(
                                listOf(
                                        intArrayOf(1, 1, 0),
                                        intArrayOf(1, 0, 1),
                                        intArrayOf(0, 0, 0)
                                ),
                                listOf(
                                        intArrayOf(1, 0, 0),
                                        intArrayOf(0, 1, 0),
                                        intArrayOf(1, 1, 1)
                                )
                        ),
                        arrayOf(
                                listOf(
                                        intArrayOf(1, 1, 0, 0),
                                        intArrayOf(1, 0, 0, 1),
                                        intArrayOf(0, 1, 1, 1),
                                        intArrayOf(1, 0, 1, 0)
                                ),
                                listOf(
                                        intArrayOf(1, 1, 0, 0),
                                        intArrayOf(0, 1, 1, 0),
                                        intArrayOf(0, 0, 0, 1),
                                        intArrayOf(1, 0, 1, 0)
                                )
                        )
                )
    }

    @Test
    fun arraysAreFlipped() {
        //Given array representations of every row of an image

        //When the image is flipped
        val result = flipImage(image.toTypedArray())

        //Then image have the expected values
        for (row in 0..(result.size - 1)) {
            for (element in (0..result[row].size - 1)) {
                assertThat(result[row][element]).isEqualTo(flippedImage[row][element])
            }
        }
    }


    private fun flipImage(image: Array<IntArray>): List<IntArray> {
        //Reverse array
        val result: Array<IntArray> = image

        for (index in 0..(result.size - 1)) {
            result[index] = result[index].reversedArray()
        }

        result.forEach {
            for (index in 0..(it.size - 1)) {
                when(it[index]) {
                    0 -> it.set(index, 1)
                    1 -> it.set(index, 0)
                }
            }

        }

        return result.toList()
    }

}
