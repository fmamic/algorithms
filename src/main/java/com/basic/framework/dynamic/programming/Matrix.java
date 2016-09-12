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

}
