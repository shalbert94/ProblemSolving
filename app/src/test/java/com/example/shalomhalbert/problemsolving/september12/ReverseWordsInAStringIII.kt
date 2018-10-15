package com.example.shalomhalbert.problemsolving.september12

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ReverseWordsInAStringIII(val input: String, val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<String>> =
                listOf(
                        arrayOf(
                                "Let's take LeetCode contest",
                                "s'teL ekat edoCteeL tsetnoc"
                        )
                )
    }

    @Test
    fun `Words reversed`() {
        //Given a string
        input
        //When its words are reversed
        val result = reverseWords(input)
        //Then result should be as expected
        assertThat(result).isEqualTo(expected)
    }

    fun reverseWords(s: String): String {
        val wordList = s.split(Regex("\\s"))
        val result = StringBuilder()
        for (word in wordList) result.append("${word.reversed()} ")
        return result.deleteCharAt(result.length-1).toString()
    }

    fun efficientReverseWords(s: String): String {
        return s.split(' ').map { it.reversed() }.joinToString(" ")
    }
}