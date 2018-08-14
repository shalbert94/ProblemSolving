package com.example.shalomhalbert.problemsolving.august14

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class HammingDistance(val arg1: Int, val arg2: Int, val hammingDistance: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>> = listOf(
                arrayOf(1, 4, 2),
                arrayOf(3, 1, 1)
        )
    }

    @Test
    fun hammingDistanceIsCorrect() {
        //Given two positive integers in their binary form
        val binary1 = arg1.toString(2)
        val binary2 = arg2.toString(2)

        //When the number of corresponding bits that are different is calculated
        val distance = hammingDistance(binary1, binary2)
//        hamm(arg1, arg2)

        //Then the value is the hamming distance
        assertThat(distance).isEqualTo(hammingDistance)
    }

    /**
     * @param binary1 is a binary representation of [arg1]
     * @param binary2 is a binary representation of [arg2]
     * @return hamming distance
     */
    private fun hammingDistance(binary1: String, binary2: String): Int {
        //Make arguments indirectly mutable
        var binary1 = binary1
        var binary2 = binary2

        var distance: Int = 0

        when {
            binary1.length > binary2.length -> {
                while (binary1.length != binary2.length) {
                    binary2 = "0${binary2}"
                }
            }
            binary1.length < binary2.length -> {
                while (binary1.length != binary2.length) {
                    binary1 = "0${binary1}"
                }
            }
        }

        for(index in 0..(binary1.length - 1)) {
            if (binary1[index] != binary2[index]) distance++
        }


        return distance
    }

    //Best implementation
    fun hamm(x: Int, y: Int): Int {
        var xor = x xor(y)
        var count = 0
        while(xor > 0) {
            count++
            xor = xor and(xor - 1)
        }
        return count
    }


}