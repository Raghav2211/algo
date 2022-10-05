package com.github.devraghav.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    
    private void combinationSum(int[] candidates, int target, List<List<Integer>> combinations, List<Integer> combination, int position) {
        if (target < 0) return;
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = position; i < candidates.length; i++) {
            combination.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], combinations, combination, i);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, combinations, new ArrayList<>(), 0);
        return combinations;
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
