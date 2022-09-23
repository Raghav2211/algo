package com.github.devraghav;

import java.util.Arrays;

public class HouseMaxRobbery2 {
    // [1,2,3,1]

    public int maxRob(int[] nums) {
        int maxRobbery = Math.max(nums[0], nums[1]);
        nums[1] = maxRobbery;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
            maxRobbery = Math.max(nums[i], maxRobbery);
        }
        return maxRobbery;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(maxRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), maxRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public static void main(String[] args) {
        HouseMaxRobbery2 houseMaxRobbery = new HouseMaxRobbery2();
        System.out.println(houseMaxRobbery.rob(new int[]{2, 3, 2}));
        System.out.println(houseMaxRobbery.rob(new int[]{2, 1, 1, 2}));
        System.out.println(houseMaxRobbery.rob(new int[]{200, 3, 140, 20, 10}));


    }
}
