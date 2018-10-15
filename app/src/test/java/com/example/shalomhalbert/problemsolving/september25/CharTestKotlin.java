package com.example.shalomhalbert.problemsolving.september25;

import android.util.Log;

import org.junit.Test;

public class CharTestKotlin {
    @Test
    public void charTesting() {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = lowerCase.toUpperCase();

        char[] lower = lowerCase.toCharArray();
        char[] higher = upperCase.toCharArray();

        for (int i = 0; i < lowerCase.length(); i++) {
            int loChar = Character.getNumericValue(lower[i]);
            String loBinary = Integer.toBinaryString(loChar);
            int hiChar = Character.getNumericValue(higher[i]);
            String hiBinary = Integer.toBinaryString(hiChar);

        }
    }
}
