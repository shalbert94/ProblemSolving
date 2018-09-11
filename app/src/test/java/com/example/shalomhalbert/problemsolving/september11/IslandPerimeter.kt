package com.example.shalomhalbert.problemsolving.september11

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class IslandPerimeter(val grid: List<IntArray>, val expected: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> =
                listOf(
                        arrayOf(
                                listOf(intArrayOf(0, 1, 0, 0),
                                        intArrayOf(1, 1, 1, 0),
                                        intArrayOf(0, 1, 0, 0),
                                        intArrayOf(1, 1, 0, 0)),
                                16
                        )
                )
    }

    @Test
    fun `Returns correct island perimeter`() {
        //Given a grid with `0` representing water, and `1` representing land
        grid
        //When calculating the land's perimeter
        val perimeter = islandPerimeter(grid.toTypedArray())
        //Then the perimeter should be as expected
        assertThat(perimeter).isEqualTo(expected)
    }

    private fun islandPerimeter(grid: Array<IntArray>): Int {
        var islandPerimeter = 0

        for (row in 0 until grid.size) {
            inner@ for (column in 0 until grid[row].size) {
                val point = grid[row][column]
                when (point) {
                    0 -> continue@inner
                    1 -> islandPerimeter += pointPerimeter(row, column, grid)
                }
            }
        }
        return islandPerimeter
    }

    private fun pointPerimeter(row: Int, column: Int, grid: Array<IntArray>): Int {
        //Add conditionals for side values
        var pointPerimeter = 0

        val top = grid.elementAtOrNull(row - 1)?.elementAtOrNull(column) ?: 0
        val bottom = grid.elementAtOrNull(row + 1)?.elementAtOrNull(column) ?: 0
        val left = grid.elementAtOrNull(row)?.elementAtOrNull(column - 1) ?: 0
        val right = grid.elementAtOrNull(row)?.elementAtOrNull(column + 1) ?: 0

        val surroundingPoints = intArrayOf(top, left, right, bottom)

        for (surroundingPoint in surroundingPoints) if (surroundingPoint == 0) pointPerimeter++

        return pointPerimeter
    }

    /**
     * Taken from top solutions
     */
    fun efficientIslandPerimeter(grid: Array<IntArray>): Int {
        var cube = 0
        var connect = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1) {
                    cube++

                    if (i+1 < grid.size && grid[i+1][j] == 1) {
                        connect++
                    }
                    if (j+1 < grid[0].size && grid[i][j+1] == 1) {
                        connect++
                    }
                }
            }
        }
        return 4*cube-2*connect
    }

}