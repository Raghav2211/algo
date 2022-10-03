package com.github.devraghav.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    public List<Integer> bestSum(int[] numbers, int targetSum, Map<Integer, List<Integer>> memoization) {
        if (memoization.containsKey(targetSum)) return memoization.get(targetSum);
        if (targetSum < 0) return null;
        if (targetSum == 0) return new ArrayList<>();

        List<Integer> bestCombination = null;

        for (int j : numbers) {
            int remain = targetSum - j;
            var combination = bestSum(numbers, remain, memoization);
            if (combination != null) {
                var exactCombination = new ArrayList<Integer>();
                exactCombination.add(j);
                exactCombination.addAll(combination);
                if (bestCombination == null || exactCombination.size() < bestCombination.size()) {
                    bestCombination = exactCombination;
                }
            }
        }
        memoization.put(targetSum, bestCombination);
        return bestCombination;
    }


    public List<Integer> bestSum(int[] bucket, int targetSum) {
        return bestSum(bucket, targetSum, new HashMap<>());
    }


    public static void main(String[] args) {
        BestSum bestSum = new BestSum();
        System.out.println(bestSum.bestSum(new int[]{3, 2}, 7));
        System.out.println(bestSum.bestSum(new int[]{5, 3, 4, 7}, 7));
        System.out.println(bestSum.bestSum(new int[]{1, 4, 5}, 8));

        System.out.println(bestSum.bestSum(new int[]{2, 3, 5}, 8));
        System.out.println(bestSum.bestSum(new int[]{2, 4}, 10));
        System.out.println(bestSum.bestSum(new int[]{1, 2, 5, 25}, 100));
        System.out.println(bestSum.bestSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(bestSum.bestSum(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }
}
