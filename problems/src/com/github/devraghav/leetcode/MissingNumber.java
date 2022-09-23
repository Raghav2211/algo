package com.github.devraghav.leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedToal = (length*(length+1))/2;
        int actualTotal = 0;
        for (int i = 0; i < length-1; i++) {
            actualTotal+=nums[i];
        }
        System.out.println("expectedToal -- "+expectedToal);System.out.println("actualTotal -- "+actualTotal);

        return expectedToal-actualTotal;
    }
}
