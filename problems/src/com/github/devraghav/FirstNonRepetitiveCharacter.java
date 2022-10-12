package com.github.devraghav;

public class FirstNonRepetitiveCharacter {

    private char firstNonRepeating(String str) {
        int[] charCount = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charCount[Character.toUpperCase(str.charAt(i)) - 65]++;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charCount[Character.toUpperCase(currentChar) - 65] == 1) {
                return currentChar;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        FirstNonRepetitiveCharacter firstNonRepetitiveCharacter = new FirstNonRepetitiveCharacter();
        System.out.println(firstNonRepetitiveCharacter.firstNonRepeating("Geeksforgeeks"));
        System.out.println(firstNonRepetitiveCharacter.firstNonRepeating("Raghav"));
        System.out.println(firstNonRepetitiveCharacter.firstNonRepeating("aabb"));
    }
}
