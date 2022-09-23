package com.github.devraghav;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
