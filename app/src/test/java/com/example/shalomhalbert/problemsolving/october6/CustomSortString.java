package com.example.shalomhalbert.problemsolving.october6;

import org.junit.Test;

public class CustomSortString {

    @Test
    public void test() {
        String s = customSortString("cba", "abcd");
        int puase = 0;
    }

    public String customSortString(String S, String T) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        for (int i = 0; i < count.length; i++) {
            int x = 97 + i;
            char c = (char) x;
            while (count[i] > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
