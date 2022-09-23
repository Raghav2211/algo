package com.github.devraghav.leetcode;

public class HouseMaxRobbery {
    // [1,2,3,1]
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxRobbery = Math.max(nums[0], nums[1]);
        nums[1] = maxRobbery;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
            maxRobbery = Math.max(nums[i], maxRobbery);
        }
        return maxRobbery;
    }

    public static void main(String[] args) {
        HouseMaxRobbery houseMaxRobbery = new HouseMaxRobbery();
        System.out.println(houseMaxRobbery.rob(new int[]{2,7,9,3,1}));
        System.out.println(houseMaxRobbery.rob(new int[]{7,2,9,3,1}));
    }
}
