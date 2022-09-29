package com.github.devraghav.slidingwindow;

import java.util.Arrays;

public class MostFrequentElement {
    //Input: nums = [1,2,4], k = 5
    public int maxFrequency(int[] nums, int k) {
        int maxWindow = 1, low = 0, high;
        long sum = 0;
        Arrays.sort(nums);
        for (high = 0; high < nums.length; ++high) {
            sum += nums[high];
            while (sum + k < (long) nums[high] * (high - low + 1)) {
                sum -= nums[low];
                low += 1;
            }
            maxWindow = Math.max(maxWindow, high - low + 1);
        }
        return maxWindow;
    }

    public static void main(String[] args) {
        MostFrequentElement mostFrequentElement = new MostFrequentElement();
//        System.out.println(mostFrequentElement.maxFrequency(new int[]{1, 2, 4}, 5));
//        System.out.println(mostFrequentElement.maxFrequency(new int[]{1, 4, 8, 13}, 5));
//        System.out.println(mostFrequentElement.maxFrequency(new int[]{3, 9, 6}, 2));
    //xor = xor ^ i ^ nums[i];
        System.out.println(3^0^0);
        System.out.println(3^1^0);
        System.out.println(2^2^1);
        System.out.println(1^3);
    }
}
