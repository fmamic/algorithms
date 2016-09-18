package com.basic.framework.dynamic.programming;

class EditDistance {

    int minumumEditDistanceNaive(final String str1, final String str2) {

        if (str1.equals(""))
            return str2.length();

        if (str2.equals(""))
            return str1.length();

        int difference = 0;

        if (str1.charAt(str1.length() - 1) != str2.charAt(str2.length() - 1)) {
            difference = 1;
        }

        return Math.min(Math.min(minumumEditDistanceNaive(str1.substring(0, str1.length() - 1), str2.substring(0 , str2.length() - 1)) + difference,
                minumumEditDistanceNaive(str1.substring(0, str1.length() - 1), str2) + 1),
                minumumEditDistanceNaive(str1, str2.substring(0, str2.length() - 1)) + 1);
    }

    int minumumEditDistance(final String str1, final String str2) {

        return 0;
    }

}
