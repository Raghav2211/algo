package com.github.devraghav.leetcode;

public class JumpGame {
    // [2,3,1,1,4]
    //[3,2,1,0,4]
    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        if(len ==0) return true;
        int reachIndex = len;
        for (int i = len; i >=0; i--) {
            int currItem = nums[i];
            int currIndex = i;
            int toReach = currIndex+currItem;
            if(toReach >= reachIndex) {
                reachIndex = currIndex;
            }

        }
        return reachIndex ==0;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));
        System.out.println(jumpGame.canJump(new int[]{3,2,2,0,4}));
    }
}
