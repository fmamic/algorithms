package com.basic.framework.dynamic.programming;

class Palindrom {

    private boolean isPalindrom(final String str) {
        final int end = str.length();

        for (int i = 0, j = end - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    int minimumCutsForPalindrom(final String str, int start, int end) {

        if (isPalindrom(str.substring(start, end + 1))) {
            return 0;
        }

        int cuts = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            cuts = Math.min(minimumCutsForPalindrom(str, start, i) + minimumCutsForPalindrom(str, i + 1, end) + 1, cuts);
        }

        return cuts;
    }

    int minimumCutsForPalindromMemo(final String str, int start, int end) {
        final int[][] memo = new int[end + 1][end + 1];

        for (int i = 0; i <= end; i++) {
            for (int j = 0; j <= end; j++) {
                memo[i][j] = -1;
            }
        }

        return minimumCutsForPalindromMemo(str, start, end, memo);
    }

    private int minimumCutsForPalindromMemo(final String str, int start, int end, int[][] memo) {

        if (isPalindrom(str.substring(start, end + 1))) {
            return 0;
        }

        int cuts = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int second;
            int first;

            if (memo[start][i] >= 0) {
                first = memo[start][i];
            } else {
                first = minimumCutsForPalindromMemo(str, start, i, memo);
                memo[start][i] = first;
            }

            if (memo[i + 1][end] >= 0) {
                second = memo[i + 1][end];
            } else {
                second = minimumCutsForPalindromMemo(str, i + 1, end, memo);
                memo[i + 1][end] = second;
            }

            cuts = Math.min(first + second + 1, cuts);
        }

        return cuts;
    }

}
