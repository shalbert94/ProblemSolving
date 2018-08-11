package com.example.shalomhalbert.problemsolving

import android.util.Log
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class JewelsAndStones(val jewels: String, val stones: String, val output: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> = listOf(
            arrayOf("aA", "aAAbbbb", 3),
            arrayOf("z", "ZZ", 0)
        )
    }

    @Test
    fun `assert equals`() {
        var jewelCounter: Int = 0
        jewels.forEach {
            val currentJewel = it
            stones.forEach {
                if(it == currentJewel) jewelCounter++
            }
        }
        assertThat(jewelCounter).isEqualTo(output)
    }
}