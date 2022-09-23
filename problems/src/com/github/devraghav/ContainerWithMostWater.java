package com.github.devraghav;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start <= end) {
            max = Math.max(max, height[start] < height[end] ? (end - start) * height[start++] : (end - start) * height[end--]);
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 1}));
    }
}
