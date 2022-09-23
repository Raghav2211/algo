package com.github.devraghav;

public class Trapping_RainWater {

    public int trap(int[] height) {

        int[] leftArray = new int[height.length];
        leftArray[0] = height[0];
        for(int i=1; i< height.length ;i++) {
            leftArray[i] = Math.max(leftArray[i-1],height[i]);
        }

        int[] rightArray = new int[height.length];
        rightArray[height.length-1]=height[height.length-1];
        for(int i=height.length-2; i>= 0 ;i--) {
            rightArray[i] = Math.max(rightArray[i+1],height[i]);
        }

        int trapWater = 0;
        for(int i=0; i< height.length ;i++) {
            int indexwater = Math.min(leftArray[i],rightArray[i])-height[i];
            if(indexwater > 0){
                trapWater+=indexwater;
            }
        }
        return trapWater;
    }

    public static void main(String[] args) {
        Trapping_RainWater trapping_rainWater = new Trapping_RainWater();
        System.out.println(trapping_rainWater.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trapping_rainWater.trap(new int[] {4,2,0,3,2,5}));
    }
}
