package com.github.devraghav.leetcode;

public class SearchInSortedArray {

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = (high + low)/2;
//            System.out.println("low "+nums[low]+" high  "+nums[high]+" mid "+nums[mid]);
            if(target == nums[mid]){
                return mid;
            }else if(target == nums[low]){
                return low;
            }else if(target == nums[high]){
                return high;
            }



            if(target < nums[mid] ) {
                if(target < nums[low] ){
                    if(nums[low] < nums[mid]){
                        low = mid+1;
                    }else{
                        low  = low+1;
                    }
                } else{
                    high = mid;
                }

            } else {
                if(target > nums[low]) {
                    if(nums[low] > nums[mid]){
                        high = mid-1;
                    }else{
                         low = mid +1;
                    }
                }else{
                    low = mid +1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInSortedArray searchInSortedArray = new SearchInSortedArray();
        System.out.println( searchInSortedArray.search(new int[]{5,1,2,3,4},1));
        System.out.println( searchInSortedArray.search(new int[]{8,9,2,3,4},9));
        System.out.println( searchInSortedArray.search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println( searchInSortedArray.search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println( searchInSortedArray.search(new int[]{1},1));

    }
}
