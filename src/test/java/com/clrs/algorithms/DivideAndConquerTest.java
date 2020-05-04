package com.clrs.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DivideAndConquerTest {

    @Test
    public void maximumSubarrayBruteTest() {
        int[] input = new int[] { 10, 11, 7, 10, 6 };
        DivideAndConquer divideAndConquer = new DivideAndConquer();

        assertEquals(3, divideAndConquer.maximumSubarrayBrute(input));
    }

    @Test
    public void findCrossingMaximumSubArrayTest() {
        int[] input = new int[] { 10, -2, 3, -10, 6, -1, -4, 2, -3, 10 };

        DivideAndConquer divideAndConquer = new DivideAndConquer();

        assertEquals(0, divideAndConquer.findCrossingMaximumSubArray(input, 0, input.length - 1, 5).low);
        assertEquals(9, divideAndConquer.findCrossingMaximumSubArray(input, 0, input.length - 1, 5).high);
        assertEquals(11, divideAndConquer.findCrossingMaximumSubArray(input, 0, input.length - 1, 5).sum);
    }

    @Test
    public void maximumSubarrayTest() {
        int[] input = new int[] { 1, -4, 3, -4 };
        int[] input2 = new int[] { -2, 5, 3, -4, 8, -1 };

        DivideAndConquer divideAndConquer = new DivideAndConquer();

        assertEquals(3, divideAndConquer.maximumSubarray(input));
        assertEquals(12, divideAndConquer.maximumSubarray(input2));
    }

    @Test
    public void squareMatrixMultiply() {
        int[][] matrixA = new int[][] { { 5, 2 }, { 8, 1 } };
        int[][] matrixB = new int[][] { { 3, 2 }, { 1, 1 } };

        DivideAndConquer divideAndConquer = new DivideAndConquer();

        int[][] result = divideAndConquer.squareMatrixMultiply(matrixA, matrixB);

        assertEquals(17, result[0][0]);
        assertEquals(12, result[0][1]);
        assertEquals(25, result[1][0]);
        assertEquals(17, result[1][1]);
    }

    @Test
    public void squareMatrixMultiplyRecursive() {
        int[][] matrixA = new int[][] { { 5, 2 }, { 8, 1 } };
        int[][] matrixB = new int[][] { { 3, 2 }, { 1, 1 } };

        DivideAndConquer divideAndConquer = new DivideAndConquer();

        int[][] result = divideAndConquer.squareMatrixMultiplyDNC(matrixA, matrixB);

        assertEquals(17, result[0][0]);
        assertEquals(12, result[0][1]);
        assertEquals(25, result[1][0]);
        assertEquals(17, result[1][1]);
    }
}