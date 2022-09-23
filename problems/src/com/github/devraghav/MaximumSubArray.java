package com.github.devraghav;

public class MaximumSubArray {
    //[-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentTotal < 0) {
                currentTotal = 0;
            }
            currentTotal += nums[i];
            max = Math.max(max, currentTotal);
        }
        return max;
    }
}
