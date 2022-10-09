package com.github.devraghav.dp;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    public List<List<Character>> permute(Character[] characters) {
        List<List<Character>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), characters);
        return list;
    }

    private void backtrack(List<List<Integer>> permutations, List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) continue;
            permutation.add(nums[i]);
            backtrack(permutations, permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }

    private void backtrack(List<List<Character>> permutations, List<Character> permutation, Character[] nums) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) continue;
            permutation.add(nums[i]);
            backtrack(permutations, permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(new int[]{1, 2, 3}));
        System.out.println(permutation.permute(new Character[]{'A', 'B', 'C'}));
    }
}
