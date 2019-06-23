package com.basic.framework.dynamic.programming;

class BinomialCoef {

    int calculateNaive(final int n, final int k) {
        if (k == 0) {
            return 1;
        }

        if (n == k) {
            return 1;
        }

        return calculateNaive(n - 1, k - 1) + calculateNaive(n - 1, k);
    }

    int calculateDP(final int n, final int k) { 

        if (n < 0) {
            return 0;
        }

        if (k > n) {
            return 0;
        }

        int[][] result = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            // populate first row with ones because (k = 0) = 1
            result[i][0] = 1;
            // populate matrix diagonal because (n == k) = 1
            if (i <= k) {
                result[i][i] = 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }

        return result[n][k];
    }

}
