package com.example.shalomhalbert.problemsolving.october4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class PartitionLabels {
    @Test
    public void test(){
        partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        if (S.length() == 0) {
            return result;
        }
        int[] array = new int[26];
        for (int i = 0; i < S.length(); i++) {
            array[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, array[S.charAt(i) - 'a']);
            if (last == i) {
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }
}
