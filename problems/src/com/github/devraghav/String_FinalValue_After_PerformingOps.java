package com.github.devraghav;

public class String_FinalValue_After_PerformingOps {
    public int finalValueAfterOperations(String[] operations) {
        int start = 0;
        for (String op : operations) {

            switch (op) {
                case "++X":
                case "X++":
                    start++;
                    break;
                case "--X":
                case "X--":
                    start--;
                    break;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        String_FinalValue_After_PerformingOps string_finalValue_after_performingOps = new String_FinalValue_After_PerformingOps();
        System.out.println(string_finalValue_after_performingOps.finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
        System.out.println(string_finalValue_after_performingOps.finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
        System.out.println(string_finalValue_after_performingOps.finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"}));
    }
}
