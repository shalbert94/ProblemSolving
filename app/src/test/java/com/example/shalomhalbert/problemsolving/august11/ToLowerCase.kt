package com.example.shalomhalbert.problemsolving.august11

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ToLowerCase (val input: String, val output: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<String>> = listOf(
            arrayOf("Hello", "hello"),
            arrayOf("here", "here"),
            arrayOf("LOVELY", "lovely")
        )
    }

    @Test
    fun convertToLowerCase() {
        var lowerCase: String = ""
        input.forEach {
            lowerCase += it.toLowerCase()
        }
        assertThat(lowerCase).isEqualTo(output)
    }

}