package com.basic.framework.dynamic.programming;

import java.util.List;

public class Matrix {

    public int[][] matrixMultiply(final int[][] matrixA, final int[][] matrixB) {

        final int[][] matrixC = new int[matrixA.length][matrixB.length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB.length; j++) {
                matrixC[i][j] = 0;
                for (int k = 0; k < matrixA.length; k++) {
                    matrixC[i][j] = matrixC[i][j] + matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return matrixC;
    }

    public int maximumSizeSubMatrix(final int[][] matrix) {
        final int[][] state = new int[matrix.length][matrix[0].length];

        int maxNumber = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    state[i][j] = 0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    state[i][j] = matrix[i][j];
                    continue;
                }
                state[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]), matrix[i][j - 1]) + 1;

                if (state[i][j] > maxNumber) {
                    maxNumber = state[i][j];
                }
            }
        }

        return maxNumber;
    }

    int optParenthesizingR(final int[] sizes, int start, int end) {
        if (start == end) {
            return 0;
        }

        int minimum = Integer.MAX_VALUE;

        for (int k = start; k < end; k++) {
            int result = optParenthesizingR(sizes, start, k) + optParenthesizingR(sizes, k + 1, end) + sizes[start - 1] * sizes[k] * sizes[end];

            if (minimum > result) {
                minimum = result;
            }
        }

        return minimum;
    }

    int optParenthesizingNumber(final int[] sizes, int start, int end) {

        int[][] opt = new int[end + 1][end + 1];
        int[][] state = new int[end + 1][end + 1];

        for (int i = 2; i < end + 1; i++) {
            opt[i][i - 1] = sizes[i - 2] * sizes[i - 1] * sizes[i];
            state[i][i - 1] = i - 1;
        }

        for (int i = start + 2; i <= end; i++) {
            for (int j = i - 2; j >= start; j--) {
                opt[i][j] = Integer.MAX_VALUE;

                for (int k = j; k < i; k++) {
                    int result = opt[k][j] + opt[i][k + 1] + sizes[j - 1] * sizes[k] * sizes[i];

                    if (result < opt[i][j]) {
                        opt[i][j] = result;
                        state[i][j] = k;
                    }
                }
            }
        }

        return opt[end][start];
    }

    String optParenthesizingStateStr(int[][] state, int i, int j) {
        String result = "";

        if (i == j) {
            return "A" + i;
        } else {
            result += "(";
            result += optParenthesizingStateStr(state, i, state[j][i]);
            result += optParenthesizingStateStr(state, state[j][i] + 1, j);
            result += ")";
        }

        return result;
    }

    int[][] optParenthesizingState(final int[] sizes, int start, int end) {

        int[][] opt = new int[end + 1][end + 1];
        int[][] state = new int[end + 1][end + 1];

        for (int i = 2; i < end + 1; i++) {
            opt[i][i - 1] = sizes[i - 2] * sizes[i - 1] * sizes[i];
            state[i][i - 1] = i - 1;
        }

        for (int i = start + 2; i <= end; i++) {
            for (int j = i - 2; j >= start; j--) {
                opt[i][j] = Integer.MAX_VALUE;

                for (int k = j; k < i; k++) {
                    int result = opt[k][j] + opt[i][k + 1] + sizes[j - 1] * sizes[k] * sizes[i];

                    if (result < opt[i][j]) {
                        opt[i][j] = result;
                        state[i][j] = k;
                    }
                }
            }
        }

        return state;
    }
}
