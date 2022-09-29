package com.github.devraghav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllLonelyNumbers {


    public List<Integer> findLonely(int[] nums) {
        if (nums.length == 0) return Arrays.asList();
        if (nums.length == 1) return Arrays.asList(nums[0]);
        List<Integer> lonelyNumbers = new ArrayList<>();
        Arrays.sort(nums);
        var zeroEle = nums[0];
        if (nums[1] != (zeroEle + 1) && nums[1] != zeroEle) {
            lonelyNumbers.add(zeroEle);
        }
        var lastEle = nums[nums.length - 1];
        if (nums[nums.length - 2] != (lastEle - 1) && nums[nums.length - 2] != lastEle) {
            lonelyNumbers.add(lastEle);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int number = nums[i];

            if (nums[i - 1] != (number - 1) && nums[i + 1] != (number + 1) && nums[i - 1] != number && nums[i + 1] != number) {
                lonelyNumbers.add(number);
            }
        }
        return lonelyNumbers;
    }

    public static void main(String[] args) {
        FindAllLonelyNumbers findAllLonelyNumbers = new FindAllLonelyNumbers();
        System.out.println(findAllLonelyNumbers.findLonely(new int[]{10, 9, 7, 7, 3, 6, 5}));
        System.out.println(findAllLonelyNumbers.findLonely(new int[]{10, 6, 5, 8}));
        System.out.println(findAllLonelyNumbers.findLonely(new int[]{1, 3, 5, 3}));
    }
}
