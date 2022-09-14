package com.github.devraghav.leetcode;

public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i];
        }

        rightProduct[nums.length - 1] = nums[nums.length - 1];
        for (int i = (nums.length - 2); i >= 0; i--) {
            rightProduct[i] = nums[i] * rightProduct[i + 1];
        }


        nums[0] = rightProduct[1];
        nums[nums.length-1] = leftProduct[nums.length-2];
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = rightProduct[i + 1] * leftProduct[i - 1];
        }
        return nums;

    }

    public static void main(String[] args) {
        ProductOfArrayExceptItself productOfArrayExceptItself = new ProductOfArrayExceptItself();
//        int[] result = productOfArrayExceptItself.productExceptSelf(new int[]{1, 2, 3, 4});
        int[] result = productOfArrayExceptItself.productExceptSelf(new int[]{-1,1,0,-3,3});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }
}
