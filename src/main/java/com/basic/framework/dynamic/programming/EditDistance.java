package com.basic.framework.dynamic.programming;

class EditDistance {

    int minimumEditDistanceNaive(final String str1, final String str2) {

        if (str1.equals(""))
            return str2.length();

        if (str2.equals(""))
            return str1.length();

        int difference = 0;

        if (str1.charAt(str1.length() - 1) != str2.charAt(str2.length() - 1)) {
            difference = 1;
        }

        return Math.min(Math.min(minimumEditDistanceNaive(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1)) + difference,
                minimumEditDistanceNaive(str1.substring(0, str1.length() - 1), str2) + 1),
                minimumEditDistanceNaive(str1, str2.substring(0, str2.length() - 1)) + 1);
    }

    int minimumEditDistance(final String str1, final String str2) {

        final int[][] state = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            state[i][0] = i;
        }

        for (int j = 0; j <= str2.length(); j++) {
            state[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    state[i][j] = state[i - 1][j - 1];
                } else {
                    state[i][j] = Math.min(Math.min(state[i - 1][j - 1], state[i - 1][j]), state[i][j - 1]) + 1;
                }
            }
        }

        return state[str1.length()][str2.length()];
    }

}
