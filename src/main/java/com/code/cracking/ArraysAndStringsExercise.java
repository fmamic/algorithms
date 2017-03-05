package com.code.cracking;

import java.util.HashSet;
import java.util.Set;

class ArraysAndStringsExercise {

    /**
     * 1.1
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you cannot use additional data structures?
     * First solution:
     * Time complexity O(n)
     * Space complexity O(n)
     */
    boolean stringWithAllUnique(final String str) {
        final Set<String> set = new HashSet<String>();

        for (int i = 0; i < str.length(); i++) {
            set.add(String.valueOf(str.charAt(i)));
        }

        return set.size() == str.length();
    }

}
