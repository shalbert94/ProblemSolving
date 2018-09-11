package com.example.shalomhalbert.problemsolving.september11

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NumberOfLinesToWriteString(val widths: List<Int>, val S: String, val expected: List<Int>) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> =
                listOf(
//                        arrayOf(
//                                listOf(10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10),
//                                "abcdefghijklmnopqrstuvwxyz",
//                                listOf(3, 60)
//                        ),
                        arrayOf(
                                listOf(4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10),
                                "bbbcccdddaaa",
                                listOf(2, 4)
                        )
                )
    }

    @Test
    fun `Testing`() {
        val response = numberOfLines(widths.toIntArray(), S)

        assertThat(response).isEqualTo(expected.toIntArray())
    }


    fun numberOfLines(widths: IntArray, S: String): IntArray {
        var lines = 1
        var width = 0
        for (c in S.toCharArray()) {
            val w = widths[c - 'a']
            width += w
            if (width > 100) {
                lines++
                width = w
            }
        }

        return intArrayOf(lines, width)
    }
}