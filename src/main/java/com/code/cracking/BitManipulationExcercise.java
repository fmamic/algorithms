package com.code.cracking;

class BitManipulationExcercise {

    /**
     * 5.1.
     * Two 32 bit numbers, N and M and two bit positions i and j. Write a method to insert M into N such that
     * M starts at bit j and ends at bit i.
     */
    int insertMintoNnumber(final int n, final int m, final int j, final int i) {
        final int bitMaskJ = (1 << j) - 1;
        final int bitMaskI = Integer.MIN_VALUE >> (32 - i - 2);
        final int finalMask = bitMaskI | bitMaskJ;
        final int moveM = m << j;

        return (finalMask & n) | moveM;
    }

}
