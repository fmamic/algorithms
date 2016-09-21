package com.basic.framework.dynamic.programming;

class LongestSubsequence {

    int longestCommonSubStringNaive(final String str1, final String str2) {
        if (str1.equals(""))
            return 0;

        if (str2.equals(""))
            return 0;

        if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
            return 1 + longestCommonSubStringNaive(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
        }

        return Math.max(longestCommonSubStringNaive(str1.substring(0, str1.length() - 1), str2), longestCommonSubStringNaive(str1, str2.substring(0, str2.length() - 1)));
    }

    int longestCommonSubString(final String str1, final String str2) {
        final int[][] state = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    state[i][j] += 1 + state[i - 1][j - 1];
                } else {
                    state[i][j] = Math.max(state[i - 1][j], state[i][j - 1]);
                }
            }
        }

        return state[str1.length()][str2.length()];
    }

    String[] findAllSubStrings(final String str1) {
        final String[] list = new String[str1.length() * str1.length()];

        int position = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 1; j <= str1.length() - i; j++) {
                list[position] = str1.substring(i, j + i);
                position++;
            }
        }

        return list;
    }

    int longestIncreasingSubsequence(final int[] sequence) {

        final int[] state = new int[sequence.length];
        int maxNumber = Integer.MIN_VALUE;

        state[0] = 1;

        for (int i = 1; i < sequence.length; i++) {
            state[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[j] <= sequence[i] && state[j] + 1 > state[i]) {
                    state[i] = state[j] + 1;
                }
            }

            if (state[i] > maxNumber) {
                maxNumber = state[i];
            }
        }

        return maxNumber;
    }


    public int longestZigZag(final int[] sequence) {
        final int[] state = new int[sequence.length + 1];
        final boolean[] zigzag = new boolean[sequence.length + 1];

        int maxNumber = 1;
        state[0] = 1;

        if (sequence.length == 1)
            return 1;

        for (int i = 1; i < sequence.length; i++) {
            state[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] - sequence[j] < 0 && (j == 0 || zigzag[j]) && state[j] + 1 > state[i]) {
                    state[i] = state[j] + 1;
                    zigzag[i] = false;
                } else if (sequence[i] - sequence[j] > 0 && (j == 0 || !zigzag[j]) && state[j] + 1 > state[i]) {
                    state[i] = state[j] + 1;
                    zigzag[i] = true;
                }
            }
            if (state[i] > maxNumber) {
                maxNumber = state[i];
            }
        }

        return maxNumber;
    }

}
