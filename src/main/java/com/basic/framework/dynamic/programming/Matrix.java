package com.basic.framework.dynamic.programming;

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

}
