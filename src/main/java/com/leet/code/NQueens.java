package com.leet.code;

import java.util.*;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 * queen and an empty space respectively.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        final int[] map = new int[n];
        final List<List<String>> result = new LinkedList<>();
        final Set<String> hashSet = new HashSet<>();

        if (n == 0)
            return new LinkedList<>();

        for (int i = 0; i < n; i++) {
            solveNQueensRec(0, i, n, map, result, hashSet);
        }

        return result;
    }

    private void solveNQueensRec(int row, int column, int n, int[] taken, List<List<String>> result, final Set<String> hashSet) {
        if (row == n) {
            final List<String> arrayList = new ArrayList<>();

            StringBuilder hashStr = new StringBuilder();
            for (int i = 0; i < n; i++) {
                final int eCol = taken[i] - 1;

                if (eCol < 0)
                    break;

                final StringBuilder stringBuilder = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if (j == eCol) {
                        stringBuilder.append("Q");
                    }
                    else {
                        stringBuilder.append(".");
                    }
                }
                hashStr.append(stringBuilder.toString());
                arrayList.add(stringBuilder.toString());
            }

            if (!hashSet.contains(hashStr.toString())) {
                hashSet.add(hashStr.toString());
                result.add(arrayList);
            }

            return;
        }

        taken[row] = column + 1;

        for (int i = 0; i < n; i++) {
            if (checkIfSuitable(row + 1, i, taken) || row + 1 == n) {
                solveNQueensRec(row + 1, i, n, taken, result, hashSet);
            }
        }

        taken[row] = 0;
    }

    private boolean solExists(final List<String> arrayList, final List<List<String>> result) {

        for (List<String> list : result) {
            if (list.equals(arrayList)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkIfSuitable(final int row, final int column, final int[] taken) {

        for (int i = 0; i < taken.length; i++) {
            int col = taken[i] - 1;

            if (col < 0)
                return true;

            if (row == i || column == col) {
                return false;
            }

            if (row + column == i + col)
                return false;

            if (row - column == i - col)
                return false;
        }

        return true;
    }

}
