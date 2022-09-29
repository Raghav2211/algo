package com.github.devraghav.slidingwindow;

public class MinimizeSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        if (target == 0 || nums.length == 0) return 0;
        int minWindow = Integer.MAX_VALUE;
        int currentSum = 0;
        int low = 0, high = 0;
        while (high <= (nums.length - 1)) {
            currentSum += nums[high];
            if (currentSum >= target) {
                minWindow = Math.min(minWindow, ((high - low) + 1));
                while (low <= high) {
                    currentSum -= nums[low];
                    low++;
                    if (currentSum < target) break;
                    minWindow = Math.min(minWindow, ((high - low) + 1));
                }
            }
            high++;
        }
        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }

    public static void main(String[] args) {
        MinimizeSizeSubArraySum minimizeSizeSubArraySum = new MinimizeSizeSubArraySum();
        System.out.println(minimizeSizeSubArraySum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minimizeSizeSubArraySum.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minimizeSizeSubArraySum.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

    }
}
