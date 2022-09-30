package com.github.devraghav.sort;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> tempList = new ArrayList<>();
        tempList.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            var prevInterval = tempList.get(tempList.size() - 1);
            if (intervals[i][0] <= prevInterval[1]) {
                prevInterval[0] = Math.min(intervals[i][0], prevInterval[0]);
                prevInterval[1] = Math.max(intervals[i][1], prevInterval[1]);
            } else {
                tempList.add(new int[]{intervals[i][0], intervals[i][1]});
            }

        }
        int[][] ans = new int[tempList.size()][2];
        for (int i = 0; i < tempList.size(); i++) {
            ans[i][0] = tempList.get(i)[0];
            ans[i][1] = tempList.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] ans = mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "-" + ans[i][1]);
        }
        System.out.println("------------ ");
        ans = mergeIntervals.merge(new int[][]{{1, 4}, {0, 4}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "-" + ans[i][1]);
        }

        System.out.println("---------------");
        ans = mergeIntervals.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + "-" + ans[i][1]);
        }


    }
}
