package com.clrs.algorithms;

public class DivideAndConquer {

    public int maximumSubarrayBrute(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int sum = prices[j] - prices[i];

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public int maximumSubarray(int[] prices) {
        return findMaximumSubarray(prices, 0, prices.length - 1).sum;
    }

    public CrossingTuple findMaximumSubarray(int[] prices, int low, int high) {
        if (high == low) {
            return new CrossingTuple(low, high, prices[low]);
        }

        int mid = (low + high) / 2;

        CrossingTuple lowTuple = findMaximumSubarray(prices, low, mid);
        CrossingTuple highTuple = findMaximumSubarray(prices, mid + 1, high);

        CrossingTuple midTuple = findCrossingMaximumSubArray(prices, low, high, mid);

        if (lowTuple.sum > highTuple.sum && lowTuple.sum > midTuple.sum) {
            return new CrossingTuple(lowTuple.low, lowTuple.high, lowTuple.sum);
        } else if (highTuple.sum > lowTuple.sum && highTuple.sum > midTuple.sum) {
            return new CrossingTuple(highTuple.low, highTuple.high, highTuple.sum);
        } else {
            return new CrossingTuple(midTuple.low, midTuple.high, midTuple.sum);
        }
    }

    public CrossingTuple findCrossingMaximumSubArray(int[] prices, int l, int h, int mid) {
        int low = mid, high = mid + 1, sumLow = 0, sumHigh = 0;

        int sum = 0;
        for (int i = mid; i >= 0; i--) {
            sum += prices[i];

            if (sum > sumLow) {
                sumLow = sum;
                low = i;
            }
        }

        sum = 0;
        for (int i = mid + 1; i <= h; i++) {
            sum += prices[i];

            if (sum > sumHigh) {
                sumHigh = sum;
                high = i;
            }
        }

        return new CrossingTuple(low, high, sumLow + sumHigh);
    }

    public int[][] squareMatrixMultiply(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;

    }

    public int[][] squareMatrixMultiplyDNC(int[][] matrixA, int[][] matrixB) {
        return squareMatrixMultiplyRecursive(matrixA, matrixB, 0, 0, 0, 0, matrixA.length);
    }

    public int[][] squareMatrixMultiplyRecursive(int[][] matrixA, int[][] matrixB, int aStart, int aEnd, int bStart,
            int bEnd, int len) {
        int n = len;
        int total = n / 2;
        int[][] result = new int[n][n];

        if (n == 1) {
            result[0][0] = matrixA[aStart][aEnd] * matrixB[bStart][bEnd];
        } else {
            copyToResult(
                    addTwoMatrices(squareMatrixMultiplyRecursive(matrixA, matrixB, aStart, aEnd, bStart, bEnd, total),
                            squareMatrixMultiplyRecursive(matrixA, matrixB, aStart, aEnd + 1, bStart + 1, bEnd, total)),
                    result, aStart, bEnd, total);

            copyToResult(addTwoMatrices(
                    squareMatrixMultiplyRecursive(matrixA, matrixB, aStart, aEnd, bStart, bEnd + 1, total),
                    squareMatrixMultiplyRecursive(matrixA, matrixB, aStart, aEnd + 1, bStart + 1, bEnd + 1, total)),
                    result, aStart, bEnd + 1, total);

            copyToResult(
                    addTwoMatrices(
                            squareMatrixMultiplyRecursive(matrixA, matrixB, aStart + 1, aEnd, bStart, bEnd, total),
                            squareMatrixMultiplyRecursive(matrixA, matrixB, aStart + 1, aEnd + 1, bStart + 1, bEnd, total)),
                    result, aStart + 1, bEnd, total);

            copyToResult(addTwoMatrices(
                    squareMatrixMultiplyRecursive(matrixA, matrixB, aStart + 1, aEnd, bStart, bEnd + 1, total),
                    squareMatrixMultiplyRecursive(matrixA, matrixB, aStart + 1, aEnd + 1, bStart + 1, bEnd + 1, total)),
                    result, aStart + 1, bEnd + 1, total);
        }

        return result;
    }

    public int[][] addTwoMatrices(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return result;
    }

    private void copyToResult(int[][] source, int[][] target, int start, int end, int total) {
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                target[start + i][end + j] = source[i][j];
            }
        }
    }

    class CrossingTuple {

        int low;
        int high;
        int sum;

        CrossingTuple(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }
}