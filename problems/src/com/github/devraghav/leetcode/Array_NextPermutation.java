package com.github.devraghav.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Array_NextPermutation {

    public void nextPermutation(int[] arr) {
        if (arr.length == 0) return;
        int len = arr.length - 1;
        int pivotIndex = len - 1;
        // find the pivot element
        for (; pivotIndex >= 0; pivotIndex--) {
            int currItem = arr[pivotIndex];
            int prevItem = arr[pivotIndex + 1];
            if (prevItem > currItem) {
                break;
            }
        }

        if (pivotIndex == -1) return;
        int replaceIndex = len;
        for (; replaceIndex >= (pivotIndex + 1); replaceIndex--) {
            int currItem = arr[replaceIndex];
            if (currItem != 0 && currItem > arr[pivotIndex]) {
                break;
            }
        }
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[replaceIndex];
        arr[replaceIndex] = temp;
        Arrays.sort(arr, pivotIndex + 1, arr.length);

    }


    public static void main(String[] args) {
        Array_NextPermutation array_nextPermutation = new Array_NextPermutation();
        int[] arr1 = new int[]{1, 3, 2};
        array_nextPermutation.nextPermutation(arr1);
        for (int item : arr1
        ) {
            System.out.print(item + ",");
        }
        System.out.println();

        int[] arr2 = new int[]{3, 2, 1};
        array_nextPermutation.nextPermutation(arr2);
        for (int item : arr2
        ) {
            System.out.print(item + ",");
        }
        System.out.println();

        int[] arr3 = new int[]{1, 5, 1};
        array_nextPermutation.nextPermutation(arr3);
        for (int item : arr3
        ) {
            System.out.print(item + ",");
        }
        System.out.println();
        int[] arr4 = new int[]{1, 2, 3};
        array_nextPermutation.nextPermutation(arr4);
        for (int item : arr4
        ) {
            System.out.print(item + ",");
        }

    }
}
