package com.github.devraghav;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_WithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        if (s == null) return 0;
        if (s.length() == 1) return 1;

        Map<Character, Integer> charLastVisibleIndexMap = new HashMap<>();

        int maxWindowSizeWithoutRepeatingChar = 0;
        for (; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            Integer lasVisibleIndex = charLastVisibleIndexMap.get(currentChar);
            if (lasVisibleIndex != null) {
                if (lasVisibleIndex < start) {
                    charLastVisibleIndexMap.remove(currentChar);
                } else {
                    start = lasVisibleIndex + 1;
                }
            }
            charLastVisibleIndexMap.put(currentChar, end);
            maxWindowSizeWithoutRepeatingChar = Math.max(maxWindowSizeWithoutRepeatingChar, ((end - start) + 1));
        }
        return maxWindowSizeWithoutRepeatingChar;
    }

    public static void main(String[] args) {
        LongestSubstring_WithoutRepeatingCharacters longestSubstring_withoutRepeatingCharacters = new LongestSubstring_WithoutRepeatingCharacters();
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("abba"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("aab"));
    }

}
