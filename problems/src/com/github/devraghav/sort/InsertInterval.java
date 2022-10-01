package com.github.devraghav.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {


    private int[][] convertListToArray(List<int[]> list) {
        int[][] ans = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            ans[j][0] = list.get(j)[0];
            ans[j][1] = list.get(j)[1];
        }
        return ans;
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tempList = new ArrayList<>();
        if (newInterval.length == 0) return intervals;

        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (newInterval[1] < currInterval[0]) {
                tempList.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    tempList.add(intervals[j]);
                }
                return convertListToArray(tempList);

            } else if (newInterval[0] > currInterval[1]) {
                tempList.add(currInterval);
            } else {
                newInterval = new int[]{Math.min(currInterval[0], newInterval[0]), Math.max(currInterval[1], newInterval[1])};
            }
        }
        tempList.add(newInterval);
        return convertListToArray(tempList);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int ans[][] = insertInterval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "-" + ans[i][1]);
        }
        System.out.println("------------------------------------------");
        int ans2[][] = insertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        for (int i = 0; i < ans2.length; i++) {
            System.out.println(ans2[i][0] + "-" + ans2[i][1]);
        }

    }
}
