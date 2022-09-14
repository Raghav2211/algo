package com.github.devraghav.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return false;
        }
        Map<Character, Integer> anagramMap = new HashMap<>();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            if (anagramMap.get(sChar[i]) == null) {
                anagramMap.put(sChar[i], 1);
            } else {
                anagramMap.put(sChar[i], (anagramMap.get(sChar[i]) + 1));
            }

        }
        for (int i = 0; i < tChar.length; i++) {
            if (anagramMap.get(tChar[i]) == null) {
                return false;
            } else {
                int occur = anagramMap.get(tChar[i]) - 1;
                if (occur == 0) {
                    anagramMap.remove(tChar[i]);
                } else {
                    anagramMap.put(tChar[i], occur);
                }
            }
        }
        return anagramMap.size() == 0;

    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        assert  !validAnagram.isAnagram("anagram","nagaram") :"Wrong answer";
        assert  !validAnagram.isAnagram("rat","car") :"Wrong answer";
    }
}
