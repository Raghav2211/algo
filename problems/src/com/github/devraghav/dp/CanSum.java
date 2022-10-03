package com.github.devraghav.dp;

import java.util.HashMap;
import java.util.Map;

// return true/false if targetSum can be achieved with the provided bucket
public class CanSum {

    private boolean bestSum(int[] bucket, int targetSum, int currentSum, Map<Integer, Boolean> memoization) {
        if (memoization.get(currentSum) != null) return memoization.get(currentSum);
        if (targetSum == currentSum) return true;
        if (targetSum < currentSum) return false;
        for (int i = 0; i < bucket.length; i++) {
            currentSum += bucket[i];
            boolean isSumExists = bestSum(bucket, targetSum, currentSum, memoization);
            if (isSumExists) {

                return true;
            }
            currentSum -= bucket[i];
        }
        memoization.put(currentSum, false);
        return false;
    }

    public boolean bestSum(int[] bucket, int targetSum) {
        return bestSum(bucket, targetSum, 0, new HashMap<>());
    }

    private boolean isSumExistsV2(int[] bucket, int targetSum, Map<Integer, Boolean> memoization) {
        if (memoization.get(targetSum) != null) return memoization.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int i = 0; i < bucket.length; i++) {
            int remain = targetSum - bucket[i];
            if (isSumExistsV2(bucket, remain, memoization)) {
                return true;
            }
        }
        memoization.put(targetSum, false);
        return false;
    }

    public boolean isSumExistsV2(int[] bucket, int targetSum) {
        return isSumExistsV2(bucket, targetSum, new HashMap<>());
    }

    public static void main(String[] args) {
        CanSum canSum = new CanSum();
//        System.out.println(canSum.bestSum(new int[]{2, 3}, 7));
//        System.out.println(canSum.bestSum(new int[]{5, 3, 4, 7}, 7));
//        System.out.println(canSum.bestSum(new int[]{2, 4}, 7));
//        System.out.println(canSum.bestSum(new int[]{2, 3, 5}, 8));
//        System.out.println(canSum.bestSum(new int[]{7, 14}, 12000));
//        System.out.println(canSum.bestSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
//        System.out.println(canSum.bestSum(new int[]{3, 34, 4, 12, 5, 2}, 30));
        System.out.println(canSum.bestSum(new int[]{2, 4}, 10));
        System.out.println("--------------------V2--------------------");
//        System.out.println(canSum.isSumExistsV2(new int[]{2, 3}, 7));
//        System.out.println(canSum.isSumExistsV2(new int[]{5, 3, 4, 7}, 7));
//        System.out.println(canSum.isSumExistsV2(new int[]{2, 4}, 7));
//        System.out.println(canSum.isSumExistsV2(new int[]{2, 3, 5}, 8));
//        System.out.println(canSum.isSumExistsV2(new int[]{7, 14}, 12000));
//        System.out.println(canSum.isSumExistsV2(new int[]{3, 34, 4, 12, 5, 2}, 9));
//        System.out.println(canSum.isSumExistsV2(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }
}
