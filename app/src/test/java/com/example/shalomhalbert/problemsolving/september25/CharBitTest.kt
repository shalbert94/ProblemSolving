package com.example.shalomhalbert.problemsolving.september25

import org.junit.Test

class CharBitTest {
    @Test
    fun `Check bit value for every letter in the alphabet`() {
        val lowerCase = "abcdefghijklmnopqrstuvwxyz"
        val upperCase = lowerCase.toUpperCase()

        for (i in 0..26) {
            val charValue = lowerCase[i].toInt()
            val lo = lowerCase[i].toInt().toString(2)
            val hi = upperCase[i].toInt()
        }
    }
}