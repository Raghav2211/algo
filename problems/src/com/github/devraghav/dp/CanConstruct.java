package com.github.devraghav.dp;

import java.util.HashMap;
import java.util.Map;

// return true if we can construct the same word with the word bank(can use same word multiple time from word bank)
public class CanConstruct {

    private boolean canConstruct(String[] wordBank, String word, String currentWord, Map<String, Boolean> memoization) {
        if (memoization.get(currentWord) != null) return memoization.get(currentWord);
        if (currentWord.equals(word)) return true;
        if (currentWord.length() > word.length() || (!currentWord.equals(word.substring(0, currentWord.length()))))
            return false;
        for (int i = 0; i < wordBank.length; i++) {
            if (canConstruct(wordBank, word, currentWord + wordBank[i], memoization)) {
                return true;
            }
        }
        memoization.put(currentWord, false);
        return false;
    }

    public boolean canConstruct(String[] wordBank, String word) {
        if (word.length() == 0) return true;
        if (wordBank.length == 0) return false;
        return canConstruct(wordBank, word, "", new HashMap<>());
    }

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        System.out.println(canConstruct.canConstruct(new String[]{"ab", "abc", "cd", "def", "abcd"}, "abcdef"));
        System.out.println(canConstruct.canConstruct(new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, "skateboard"));
        System.out.println(canConstruct.canConstruct(new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, "enterapotentpot"));
        System.out.println(canConstruct.canConstruct(new String[]{"e", "ee", "eeeee", "eeeeeeeeee", "eeeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeee"}, "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef"));
    }
}
