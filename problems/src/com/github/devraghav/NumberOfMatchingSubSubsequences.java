package com.github.devraghav;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOfMatchingSubSubsequences {

    public int numMatchingSubseq(String string, String[] words) {
        if (string.length() == 0 || words.length == 0) return 0;
        int subseq = 0;
        Map<String, Long> uniqueWords = Arrays.asList(words)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String subSequence : uniqueWords.keySet()) {
            int i = 0, j = 0, n = subSequence.length();
            while (i < string.length() && j < n) {
                if (string.charAt(i) == subSequence.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == n) subseq += uniqueWords.get(subSequence);
        }
        return subseq;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubSubsequences numberOfMatchingSubSubsequences = new NumberOfMatchingSubSubsequences();
        System.out.println(numberOfMatchingSubSubsequences.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(
                numberOfMatchingSubSubsequences.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
        System.out.println(numberOfMatchingSubSubsequences.numMatchingSubseq("qlhxagxdqh", new String[]{"qlhxagxdq", "qlhxagxdq", "lhyiftwtut", "yfzwraahab"}));
        System.out.println(numberOfMatchingSubSubsequences.numMatchingSubseq("rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac", new String[]{"wpddkvbnn", "lnagtva", "kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju", "rwpddkvbnnugln", "gloeofnpjqlkdsqvruvabjrikfwronbrdyyj", "vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos", "mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina", "rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip", "fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq", "qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"}));

    }
}
