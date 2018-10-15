package com.example.shalomhalbert.problemsolving.october1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

public class KeyboardRow {

    @Test
    public void test(){
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        findWords(words);
    }

    public String[] findWords(String[] words) {
        ArrayList<String> out = new ArrayList<>();
        TreeMap<Character, Integer> ref = new TreeMap<>();

        populateMap(ref);

        outerloop: for (String word : words) {
            String lower = word.toLowerCase();
            int a = ref.get(lower.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                int b = ref.get(lower.charAt(i));
                if (a != b) {
                    continue outerloop;
                }
            }
            out.add(word);
        }
        String[] arr = new String[out.size()];
        arr = out.toArray(arr);
        return arr;
    }

    private void populateMap(TreeMap<Character, Integer> map) {
        char[] top = {'q','w','e','r','t','y','u','i','o','p'};
        char[] mid = {'a','s','d','f','g','h','j','k','l'};
        char[] btm = {'z','x','c','v','b','n','m'};

        for (char c : top) {
            map.put(c, 0);
        }
        for (char c : mid) {
            map.put(c, 1);
        }
        for (char c : btm) {
            map.put(c, 2);
        }
    }
}
