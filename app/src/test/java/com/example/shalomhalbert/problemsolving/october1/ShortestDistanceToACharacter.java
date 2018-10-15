package com.example.shalomhalbert.problemsolving.october1;

import org.junit.Test;

public class ShortestDistanceToACharacter {

    @Test
    public void test() {
        String inputString = "loveleetcode";
        char inputChar = 'e';
        int[] result = shortestToChar(inputString, inputChar);
        int pausePoint = 0;
    }

    public int[] shortestToChar(String S, char C) {
        int[] r = new int[S.length()];
        int next = findChar(S, C, 0);
        int prev = -1;

        for (int i = 0; i < S.length(); i++){
            int toNext = next - i;
            int toPrev = i - prev;

            if(prev < 0 || toNext < toPrev && prev > 0) {
                r[i] = toNext;
            } else {
                r[i] = toPrev;
            }

            if (i == next) {
                prev = next;
                next = findChar(S, C, i + 1);
            }
        }
        return r;
    }

    private int findChar(String S, char C, int index) {
        for (int i = index; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                return i;
            }
        }
        return -1;
    }
}
