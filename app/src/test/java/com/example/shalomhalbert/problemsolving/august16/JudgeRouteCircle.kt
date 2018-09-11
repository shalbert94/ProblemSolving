package com.example.shalomhalbert.problemsolving.august16

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class JudgeRouteCircle(val moves: String, val output: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> =
                listOf(
                        arrayOf("UD", true),
                        arrayOf("LL", false)

                )
    }

    @Test
    fun `Robot complete a circle`() {
        //Given a String representation of moves
        moves

        //When the movements are made
        val circled = judgeCircleBest(moves)

        //Then true should be returned if the robot ends at the starting point, and false if not
        assertThat(circled).isEqualTo(output)

    }

    /**
     * @param moves A string of chars that indicate the robot's movements
     * @return Whether the robot stops at the starting point
     */
    private fun judgeCircle(moves: String): Boolean {
        var position = arrayOf(0, 0)

        for(movement in  moves.toCharArray()) {
            when (movement) {
                'U' -> position[1] += 1
                'D' -> position[1] -= 1
                'R' -> position[0] += 1
                'L' -> position[0] -= 1
            }
        }

        return position.contentEquals(arrayOf(0, 0))
    }

    /**
     * Solution taken from fastest runtime
     */
    private fun judgeCircleBest(moves: String): Boolean {
        var x = 0
        var y = 0

        for(movement in  moves.toCharArray()) {
            when (movement) {
                'U' -> y++
                'D' -> y--
                'R' -> x++
                'L' -> x--
            }
        }

        return x == 0 && y == 0
    }
}