package com.example.shalomhalbert.problemsolving.october2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindAndReplacePattern {

    @Test
    public void test() {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> result = findAndReplacePattern(words, pattern);
        int pause = 0;
//        Output: ["mee","aqq"]
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> r = new ArrayList<>();
        ArrayList<Integer> pat = sequence(pattern);
        for (String word : words) {
            if (sequencesMatch(word, pat)) {
                r.add(word);
            }
        }
        return r;
    }

    private boolean sequencesMatch(String s, ArrayList<Integer> pat) {
        int val = 1;
        char[] chars = s.toCharArray();
        TreeMap<Character, Integer> key = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!key.containsKey(chars[i])) {
                key.put(chars[i], val++);
            }

            int x = key.get(chars[i]);
            int y = pat.get(i);
            if (x != y) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> sequence(String s) {
        int val = 1;
        ArrayList<Integer> seq = new ArrayList<>();
        TreeMap<Character, Integer> key = new TreeMap<>();

        for (char c : s.toCharArray()) {
            if (!key.containsKey(c)) {
                key.put(c, val++);
            }
            seq.add(key.get(c));
        }
        return seq;
    }
}
