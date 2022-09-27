package com.github.devraghav.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTravelerWithObstacle {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        return uniquePathsWithObstacles(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, new HashMap<>());
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int column, Map<String, Integer> memoization) {
        if (row < 0 || column < 0) return 0;
        if (obstacleGrid[row][column] == 1) return 0;
        if (row == 0 && column == 0 && (obstacleGrid[row][column] == 0)) return 1;
        var key = row + "-" + column;
        var memoizeValue = memoization.get(key);
        if (memoizeValue != null) return memoizeValue;
        memoization
                .put(key,
                        uniquePathsWithObstacles(obstacleGrid, row - 1, column, memoization)
                                + uniquePathsWithObstacles(obstacleGrid, row, column - 1, memoization));
        return memoization.get(key);
    }

    public static void main(String[] args) {
        GridTravelerWithObstacle gridTraveler = new GridTravelerWithObstacle();
        System.out.println(gridTraveler.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(gridTraveler.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(gridTraveler.uniquePathsWithObstacles(new int[][]{{1, 0}}));

    }

}
