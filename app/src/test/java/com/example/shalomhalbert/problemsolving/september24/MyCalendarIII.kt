package com.example.shalomhalbert.problemsolving.september24

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*



@RunWith(Parameterized::class)
class MyCalendarIII(val bookingsInput: List<IntArray>, val kOutput: List<IntArray>) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<List<IntArray>>> =
                listOf(
//                        arrayOf(
//                                listOf(intArrayOf(10, 20), intArrayOf(50, 60), intArrayOf(10, 40),
//                                        intArrayOf(5, 15), intArrayOf(5, 10), intArrayOf(25, 55)),
//                                listOf(intArrayOf(1, 1, 2, 3, 3, 3))
//                        ),
                        arrayOf(
                                listOf(intArrayOf(24, 40), intArrayOf(43, 50), intArrayOf(27, 43),
                                        intArrayOf(5, 21), intArrayOf(30, 40), intArrayOf(14, 29),
                                        intArrayOf(3, 19), intArrayOf(3, 14), intArrayOf(25, 39),
                                        intArrayOf(6, 19)),
                                listOf(intArrayOf(1, 1, 2, 2, 3, 3, 3, 3, 4, 4))
                        )
                )
    }

    @Test
    fun `Calendar booking returns correct K`() {
        //Given an input of all the arrays for bookings and their corresponding return values when book() is called

        //When a MyCalendarII instance is create
        val calendar = MyCalendar()

        // Then the expected value should be returned when calling book()
        for (index in 0 until bookingsInput.size) {
            val booking = bookingsInput[index]
            val expected = kOutput[0][index]
            val bookOutput = calendar.book(booking[0], booking[1])
            assertThat(bookOutput).isEqualTo(expected)
        }
    }
}

class MyCalendar {
    val delta: TreeMap<Int, Int> = TreeMap()

    fun book(start: Int, end: Int): Int {
        delta[start] = delta.getOrDefault(start, 0) + 1 //Add a start point
        delta[end] = delta.getOrDefault(end, 0) + 1 //Add an end point

        var activeBookings = 0 //Tracks how many bookings have started and ended. (1) for starting and (-1) for ending
        var answer = 0
        for (d in delta.values) {
            activeBookings += d
            if (activeBookings > answer) {
                answer = activeBookings
            }
        }
        return answer
    }


//    val bookings: HashMap<Int, Int> = hashMapOf() //Key is time slot, Value is K value for that slot
//    var k = 0
//
//    fun bookWithHashMap(start: Int, end: Int): Int {
//
//        for (time in start until end) {
//            bookings[time] = bookings.getOrDefault(time, 0) + 1
//            if (bookings[time]!! > k) {
//                k = bookings[time]!!
//            }
//        }
//        return k
//    }

//    fun bookWithArray(start: Int, end: Int): Int {
//        for (time in start until end) {
//            if (++bookings[time] > k) k = bookings[time]
//        }
//        return k
//    }
}