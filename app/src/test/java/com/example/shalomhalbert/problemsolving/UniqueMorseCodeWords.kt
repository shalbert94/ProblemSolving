package com.example.shalomhalbert.problemsolving

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.Serializable

@RunWith(Parameterized::class)
class UniqueMorseCodeWords(val words: List<String>, val output: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> = listOf(
            arrayOf(listOf("gin", "zen", "gig", "msg"), 2),
                arrayOf(listOf("rwjje","aittjje","auyyn","lqtktn","lmjwn"), 1)
        )
    }

    @Test
    fun convertToMorseCode() {
        val keys = "abcdefghijklmnopqrstuvwxyz".toCharArray()
        val values = arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-",
            "-.--","--..")

        val mappedValues = keys.zip(values).toMap()

        val uniqueCodes: MutableList<String> = mutableListOf()
        words.forEach {
            var code: String = ""
            it.forEach {
                code += mappedValues.get(it)
            }
            if (!uniqueCodes.contains(code)) uniqueCodes.add(code)
        }

        assertThat(uniqueCodes.size).isEqualTo(output)

    }
}