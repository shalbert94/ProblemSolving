package com.example.shalomhalbert.problemsolving.september12

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MiddleOfTheLinkedList(val nodeValues: List<Int>, val expected: Int) {

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>> =
                listOf(
                        arrayOf(
                                listOf(1, 2, 3, 4, 5),
                                3
                        ),
                        arrayOf(
                                listOf(1,2,3,4,5,6),
                                4
                        )
                )
    }

    @Test
    fun `Returns middle node`() {
        //Given a LinkedList
        val linkedList = buildLinkedList()
        //When iterating to the list's middle node
        val middleNode = middleNode(linkedList)
        //Then the middle node should have the expected value
        assertThat(middleNode?.`val`).isEqualTo(expected)
    }

    /**
     * Build LinkedList from list of Integers
     */
    private fun buildLinkedList(): ListNode? {
        var head: ListNode? = null
        for (value in nodeValues.reversed()) {
            val newNode = ListNode(value)
            newNode.next = head
            head = newNode
        }
        return head
    }

    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }
}

