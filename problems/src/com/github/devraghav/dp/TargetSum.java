package com.github.devraghav.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    private int findTargetSumWays(int[] nums, int target, int len, Map<String, Integer> memoization) {
        var key = target + "-" + len;
        if (memoization.get(key) != null) return memoization.get(key);
        if (target == 0 && len == 0) return 1;
        if (len == 0) return 0;
        int ways = findTargetSumWays(nums, target - nums[len - 1], len - 1, memoization) +
                findTargetSumWays(nums, target + nums[len - 1], len - 1, memoization);
        memoization.put(key, ways);
        return ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, nums.length, new HashMap<>());
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
