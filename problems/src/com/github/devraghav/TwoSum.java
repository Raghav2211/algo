package com.github.devraghav;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            Integer remainIndex = map.get(remain);
            if (remainIndex != null && remainIndex != i) {
                ans[0] = i;
                ans[1] = remainIndex;
                break;
            }
        }
        return ans;
    }
}
