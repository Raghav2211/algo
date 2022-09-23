package com.github.devraghav.leetcode;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> aa = new HashSet<>();
        for (int num1 : nums
        ) {
            if (!aa.add(num1)) {

                return true;

            }
        }
        return false;
    }
}
