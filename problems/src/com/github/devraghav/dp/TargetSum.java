package com.github.devraghav.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    // TODO : memoization 
    public int findTargetSumWays(int[] nums, int target, int len) {
        if (target == 0 && len == 0) return 1;
        if (len == 0) return 0;
        return findTargetSumWays(nums, target - nums[len - 1], len - 1) +
                findTargetSumWays(nums, target + nums[len - 1], len - 1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, nums.length);
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
