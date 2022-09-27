package com.github.devraghav.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

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
        LongestSubstringWithoutRepeatingCharacters longestSubstring_withoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("abba"));
        System.out.println(longestSubstring_withoutRepeatingCharacters.lengthOfLongestSubstring("aab"));
    }

}
