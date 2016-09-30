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

}
