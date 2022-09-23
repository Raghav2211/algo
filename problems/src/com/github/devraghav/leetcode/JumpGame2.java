package com.github.devraghav.leetcode;

public class JumpGame2 {
    //[2,3,1,1,4]
    public int jump(int[] nums) {
        int minJump = 0;
        int left=0 , right = 0;
        while(right< (nums.length-1)) {
            int max = 0;
            for(int j = left ; j< right+1 ; j++){
                max = Math.max(max,j+nums[j]);
            }
            left = right + 1;
            right = max;
            minJump++;

        }
        return minJump;
    }

    public static void main(String[] args) {
        JumpGame2 jumpGame2  = new JumpGame2();
        System.out.println(jumpGame2.jump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame2.jump(new int[]{2,3,0,1,4}));
    }
}
