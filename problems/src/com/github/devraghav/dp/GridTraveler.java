package com.github.devraghav.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    public long travel(int noOfGridRow, int noOfGridColumn) {
        return travel(noOfGridRow, noOfGridColumn, new HashMap<>());
    }

    public long travel(int noOfGridRow, int noOfGridColumn, Map<String, Long> memoization) {
        if (noOfGridRow == 0 || noOfGridColumn == 0) return 0;
        if (noOfGridRow == 1 || noOfGridColumn == 1) return 1;
        var key = noOfGridRow + "-" + noOfGridColumn;
        if (memoization.containsKey(key))
            return memoization.get(key);
        memoization.put(key, travel(noOfGridRow - 1, noOfGridColumn, memoization) + travel(noOfGridRow, noOfGridColumn - 1, memoization));
        return memoization.get(key);
    }


    public static void main(String[] args) {
        GridTraveler gridTraveler = new GridTraveler();
        System.out.println(gridTraveler.travel(1, 0));
        System.out.println(gridTraveler.travel(1, 1));
        System.out.println(gridTraveler.travel(2, 3));
        System.out.println(gridTraveler.travel(3, 2));
        System.out.println(gridTraveler.travel(3, 3));
        System.out.println(gridTraveler.travel(3, 7));
        System.out.println(gridTraveler.travel(18, 18));
    }

}
