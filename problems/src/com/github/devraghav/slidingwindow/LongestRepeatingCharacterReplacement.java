package com.github.devraghav.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int len = s.length() - 1;
        if (len == 0) return 1;

        int[] charOccurrence = new int[26];
        int maxCharInWindow = 0;

        int low = 0;
        int high = 0;
        int maxWindowLen = 0;

        while (high <= len) {
            char currentChar = s.charAt(high);
            var index = currentChar - 65;
            charOccurrence[index] += 1;
            maxCharInWindow = Math.max(maxCharInWindow, charOccurrence[index]);
            var windowLen = (high - low) + 1;
            var isWindowOK = (windowLen - maxCharInWindow) <= k;
            if (isWindowOK) {
                maxWindowLen = Math.max(maxWindowLen, windowLen);
            } else {
                while (true) {
                    currentChar = s.charAt(low);
                    index = currentChar - 65;
                    charOccurrence[index] -= 1;
                    low++;
                    windowLen = (high - low) + 1;
                    maxCharInWindow = Math.max(maxCharInWindow, charOccurrence[index]);
                    isWindowOK = (windowLen - maxCharInWindow) <= k;
                    if (isWindowOK) {
                        maxWindowLen = Math.max(maxWindowLen, windowLen);
                        break;
                    }
                }
            }
            high++;
        }
        return maxWindowLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("ABC", 2));
    }
}
