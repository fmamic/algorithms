package com.leet.code;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * A knight is placed on the first block of an empty board and, moving according to the rules of chess,
 * must visit each square exactly once.
 */
class KnightsTour {

    String solveKnightsTour(int size) {
        final int[][] matrix = new int[size][size];
        List<String> result = new ArrayList<>();
        solveKnightsTourRec(matrix, size * size, 0, 0, 0, size, result);

        return Joiner.on(";").join(result);
    }

    private boolean solveKnightsTourRec(final int[][] matrix, int total, int steps, int i, int j, int size, List<String> resultStr) {
        if (total == steps) {
            return true;
        }

        if (matrix[i][j] != 0) {
            return false;
        }

        matrix[i][j] = 1;
        steps = steps + 1;

        boolean result = false;
        if (j + 2 < size && i + 1 < size) {
            result = solveKnightsTourRec(matrix, total, steps, i + 1, j + 2, size, resultStr);
        }

        if (i + 2 < size && j + 1 < size) {
            result = solveKnightsTourRec(matrix, total, steps, i + 2, j + 1, size, resultStr);
        }

        if (j + 2 < size && i - 1 >= 0) {
            result = solveKnightsTourRec(matrix, total, steps, i - 1, j + 2, size, resultStr);
        }

        if (j - 2 >= 0 && i + 1 < size) {
            result = solveKnightsTourRec(matrix, total, steps, i + 1, j - 2, size, resultStr);
        }
        if (j - 2 >= 0 && i - 1 >= 0) {
            result = solveKnightsTourRec(matrix, total, steps, i - 1, j - 2, size, resultStr);
        }

        if (i + 2 < size && j - 1 >= 0) {
            result = solveKnightsTourRec(matrix, total, steps, i + 2, j - 1, size, resultStr);
        }

        if (i - 2 >= 0 && j + 1 < size) {
            result = solveKnightsTourRec(matrix, total, steps, i - 2, j + 1, size, resultStr);
        }

        if (i - 2 >= 0 && j - 1 >= 0) {
            result = solveKnightsTourRec(matrix, total, steps, i - 2, j - 1, size, resultStr);
        }

        if (!result) {
            matrix[i][j] = 0;

            for (int k = 0; k < matrix.length; k++) {
                for (int p = 0; p < matrix[k].length; p++) {
                    System.out.print(matrix[k][p] + " ");
                }
                System.out.println();
            }
            System.out.println("-------------------------");
        } else {
            resultStr.add(i + ":" + j);
        }

        return result;
    }

}