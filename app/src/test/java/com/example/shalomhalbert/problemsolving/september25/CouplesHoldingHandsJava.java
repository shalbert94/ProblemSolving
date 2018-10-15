package com.example.shalomhalbert.problemsolving.september25;

import org.junit.Test;

public class CouplesHoldingHandsJava {


    @Test
    public void testArray() {
        TestClass obj = new TestClass();
        int[] array = {1, 2, 3, 4, 5, 6};
        obj.shuffle(array);
        return;

    }

    class TestClass {
        public void shuffle(int[] a) {
            int N = a.length;
            for (int i = 0; i < N; i++) {
                int r = (int) (i + Math.random() * (N - i));     // between i and N-1
                int temp = a[i];
                a[i] = a[r];
                a[r] = temp;
            }
        }
    }
}
