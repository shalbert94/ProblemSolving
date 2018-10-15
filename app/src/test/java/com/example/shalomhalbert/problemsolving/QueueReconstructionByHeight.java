package com.example.shalomhalbert.problemsolving;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {

    @Test
    public void test() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = reconstructQueue(people);
        int pause = 0;
    }

    public int[][] reconstructQueue(int[][] people) {
        //Sort people

//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] < o2[0] ||
//                        o1[0] == o2[0] && o1[1] > o2[1]) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        });
        for (int i = 0; i < people.length; i++) {
            int hi = i;
            for (int j = i + 1; j < people.length; j++) {
                if (people[hi][0] < people[j][0]
                        || people[hi][0] == people[j][0] && people[hi][1] > people[j][1]) {
                    hi = j;
                }
            }

            if (hi != i) {
                int[] temp = people[hi];
                people[hi] = people[i];
                people[i] = temp;
            }
        }

        //Build linked list
        Node head = new Node(null, new int[]{people[0][0] + 1, 0});
        for (int i = 0; i < people.length; i++) {
            buildLinkedList(head, people[i], 0);
        }

        //Convert Linked List to array
        head = head.next;
        for (int i = 0; i < people.length; i++) {
            people[i] = head.vals;
            head = head.next;
        }

        return people;
    }

    private void buildLinkedList(Node node, int[] person, int k) {
        if (k == person[1]) {
            node.next = new Node(node.next, person);
        } else {
            buildLinkedList(node.next, person, k + 1);
        }

    }


    class Node {
        public Node next;
        public int[] vals;

        public Node(Node next, int[] vals) {
            this.next = next;
            this.vals = vals;
        }
    }
}
