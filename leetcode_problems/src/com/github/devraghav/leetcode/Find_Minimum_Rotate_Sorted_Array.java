package com.github.devraghav.leetcode;

public class Find_Minimum_Rotate_Sorted_Array {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int minimum = nums[0];
        while (low <= high) {
            if (nums[low] < nums[high]) {
                minimum = Math.min(minimum, nums[low]);
                break;
            }
            int mid = (high + low) / 2;
            int midEle = nums[mid];
            minimum = Math.min(minimum, midEle);
            int leftMostEle = nums[low];
            int rightMostEle = nums[high];
            if (midEle >= leftMostEle) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        Find_Minimum_Rotate_Sorted_Array find_minimum_rotate_sorted_array = new Find_Minimum_Rotate_Sorted_Array();
        System.out.println( find_minimum_rotate_sorted_array.findMin(new int[]{3,4,5,1,2}));
        System.out.println(find_minimum_rotate_sorted_array.findMin(new int[]{4,5,6,7,0,1,2}));

    }
}
