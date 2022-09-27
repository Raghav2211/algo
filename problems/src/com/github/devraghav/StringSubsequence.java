package com.github.devraghav;

public class StringSubsequence {
    //abc
    public void printAllSubSequence(String s) {
        if (s.length() == 0) return;
        printAllSubSequence(s, 0, "");
    }

    private void printAllSubSequence(String s, int currIndex, String newString) {
        if (currIndex == s.length()) {
            System.out.println(newString);
            return;
        }
        printAllSubSequence(s, currIndex + 1, newString + s.charAt(currIndex));
        printAllSubSequence(s, currIndex + 1, newString);
    }


    public static void main(String[] args) {
        StringSubsequence stringSubsequence = new StringSubsequence();
        stringSubsequence.printAllSubSequence("abc");

    }
}
