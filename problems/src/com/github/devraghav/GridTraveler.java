package com.github.devraghav;

public class GridTraveler {

    public long travel(int noOfGridRow, int noOfGridColumn) {
        return travel(noOfGridRow, noOfGridColumn, new long[noOfGridRow][noOfGridColumn]);
    }

    public long travel(int noOfGridRow, int noOfGridColumn, long[][] memoization) {
        if (noOfGridRow == 0 || noOfGridColumn == 0) return 0;
        if (noOfGridRow == 1 || noOfGridColumn == 1) return 1;
        if (memoization[noOfGridRow - 1][noOfGridColumn - 1] != 0)
            return memoization[noOfGridRow - 1][noOfGridColumn - 1];
        memoization[noOfGridRow - 1][noOfGridColumn - 1] = travel(noOfGridRow - 1, noOfGridColumn, memoization) + travel(noOfGridRow, noOfGridColumn - 1, memoization);
        return memoization[noOfGridRow - 1][noOfGridColumn - 1];
    }


    public static void main(String[] args) {
        GridTraveler gridTraveler = new GridTraveler();
        System.out.println(gridTraveler.travel(1, 1));
        System.out.println(gridTraveler.travel(2, 3));
        System.out.println(gridTraveler.travel(3, 2));
        System.out.println(gridTraveler.travel(3, 3));
        System.out.println(gridTraveler.travel(18, 18));
    }

}
