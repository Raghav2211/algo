package com.github.devraghav.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

    public List<Integer> doAndReturnList(int[] bucket, int targetSum, Map<Integer, List<Integer>> memoization) {
        if (memoization.containsKey(targetSum)) return memoization.get(targetSum);
        if (targetSum == 0) return new ArrayList<Integer>();
        if (targetSum < 0) return null;
        for (int j : bucket) {
            int remain = targetSum - j;
            var elements = doAndReturnList(bucket, remain);
            if (elements != null) {
                elements.add(j);
                memoization.put(targetSum, elements);
                return elements;
            }
        }
        memoization.put(targetSum, null);
        return null;
    }


    public List<Integer> doAndReturnList(int[] bucket, int targetSum) {
        return doAndReturnList(bucket, targetSum, new HashMap<>());
    }


    public static void main(String[] args) {
        HowSum howSum = new HowSum();
        System.out.println(howSum.doAndReturnList(new int[]{2, 3}, 7));
        System.out.println(howSum.doAndReturnList(new int[]{5, 3, 4, 7}, 7));
        System.out.println(howSum.doAndReturnList(new int[]{2, 4}, 7));
        System.out.println(howSum.doAndReturnList(new int[]{2, 4}, 10));
        System.out.println(howSum.doAndReturnList(new int[]{2, 3, 5}, 8));
        System.out.println(howSum.doAndReturnList(new int[]{2, 4, 6, 7,  50, 32}, 3000));
        System.out.println(howSum.doAndReturnList(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(howSum.doAndReturnList(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }
}
