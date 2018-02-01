package com.leet.code;

public class PalindromeMinCuts {

    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0, j = 1; j < s.length(); i++, j++) {
            isPalindrome[i][i] = true;
            if (s.charAt(i) == s.charAt(j)) {
                isPalindrome[i][j] = true;
            }
        }
        isPalindrome[s.length() - 1][s.length() - 1] = true;

        for (int j = 2; j < s.length(); j++) {
            for (int i = j - 2; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                }
            }
        }

        int[] minCuts = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            int temp = Integer.MAX_VALUE;
            if (isPalindrome[0][i]) {
                minCuts[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i] && temp > minCuts[j] + 1) {
                        temp = minCuts[j] + 1;
                    }
                }
                minCuts[i] = temp;
            }

        }

        return minCuts[s.length() - 1];
    }
}
