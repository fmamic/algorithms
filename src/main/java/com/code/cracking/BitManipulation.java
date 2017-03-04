package com.code.cracking;

/**
 * Class for simple bit manipulation
 */
class BitManipulation {

    /**
     * Returns boolean if bit on index is 1 then true else false
     */
    boolean getBit(final int num, final int index) {
        final int bitMask = 1 << index;
        return (num & bitMask) != 0;
    }

    /**
     * Set bit means setting bit 1 on position index
     */
    int setBit(final int num, final int index) {
        final int bitMask = 1 << index;
        return num | bitMask;
    }

    /**
     * Clears bit from position index (setting to 0)
     */
    int clearBit(final int num, final int index) {
        final int bitMask = ~(1 << index);
        return num & bitMask;
    }

    /**
     * This method clears bit from most significant to position index
     */
    int clearFromMStoIndex(int num, final int index) {
        final int bitMask = (1 << index) - 1;
        return num & bitMask;
    }

    int updateBitOnIndex(final int num, final int index, final int update) {
        final int bitMask = ~(1 << index);
        return (num & bitMask) | (update << index);
    }

}
