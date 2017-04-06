package com.basic.framework.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

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

    private int minCutsPalindromeD(final String str) {
        boolean[][] state = new boolean[str.length()][str.length()];

        // diagonal one char
        for (int i = 0; i < str.length(); i++) {
            state[i][i] = true;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                state[i][i + 1] = true;
            }
        }

        for (int i = 3; i < str.length(); i++) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                int k = i + j + 1;
                if (str.charAt(i) == str.charAt(j) && state[i + 1][j - 1]) {
                    state[i][j] = true;
                }
            }
        }

        int[] cuts = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            int temp = Integer.MAX_VALUE;

            if (state[0][i]) {
                cuts[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if ((state[j + 1][i]) && temp > cuts[i] + 1) {
                        temp = cuts[j] + 1;
                    }
                }
                cuts[i] = temp;
            }
        }

        return 0;
    }

    public String longestPalindrome(String s) {
        final int strLen = s.length();
        final boolean[][] isPalindrome = new boolean[strLen][strLen]; // O(n^2) space

        int palindromeBeginsAt = 0;
        int maxLen = 1;

        for (int i = 0; i < strLen; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 1; i < strLen; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                isPalindrome[i][i-1] = true;
                palindromeBeginsAt = i - 1;
                maxLen = 2;
            }
        }

        // O(n^2)
        for (int i = 2; i < strLen; i++) {
            for (int j = i - 2; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i-1][j+1]) {
                    isPalindrome[i][j] = true;
                    int currLen = i - j + 1;
                    if (currLen > maxLen) {
                        palindromeBeginsAt = j;
                        maxLen = i - j + 1;
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }

        return s.substring(palindromeBeginsAt, palindromeBeginsAt + maxLen);
    }

}
