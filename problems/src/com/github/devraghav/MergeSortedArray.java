package com.github.devraghav;

public class MergeSortedArray {
    // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        while (n > 0 && m > 0) {
            int numFrom1 = nums1[m - 1];
            int numFrom2 = nums2[n - 1];
            if (numFrom1 > numFrom2) {
                nums1[(n + m) - 1] = numFrom1;
                m--;
            } else {
                nums1[(n + m) - 1] = numFrom2;
                n--;
            }
        }
        while (n > 0) {
            nums1[(n + m) - 1] = nums2[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        mergeSortedArray.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        for (int num : nums1
        ) {
            System.out.print(num + ",");
        }
        System.out.println();
        System.out.println("--------------------------------------");
        nums1 = new int[]{1};
        mergeSortedArray.merge(nums1, 1, new int[]{}, 0);
        for (int num : nums1
        ) {
            System.out.print(num + ",");
        }
        System.out.println();
        System.out.println("--------------------------------------");
        nums1 = new int[]{0};
        mergeSortedArray.merge(nums1, 0, new int[]{1}, 1);
        for (int num : nums1
        ) {
            System.out.print(num + ",");
        }
    }
}
