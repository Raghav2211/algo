package com.github.devraghav.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, combinations, new ArrayList<>(), 0);
        return combinations;

    }

    private void combinationSum2(int[] candidates, int target, List<List<Integer>> combinations, List<Integer> combination, int position) {
        if (target < 0) return;
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = position; i < candidates.length; i++) {
            if(i > position && candidates[i] == candidates[i-1]) continue;
            combination.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], combinations, combination, i+1);
            combination.remove(combination.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        System.out.println(combinationSum.combinationSum2(new int[]{1,1,2,5,6,7,10}, 8));

    }
}
