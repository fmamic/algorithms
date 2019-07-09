package com.code.cracking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitManipulationTest {

    @Test
    public void getBitTest() {
        int num = 100100;
        BitManipulation bitManipulation = new BitManipulation();

        assertEquals(true, bitManipulation.getBit(num, 2));
        assertEquals(false, bitManipulation.getBit(num, 3));
        assertEquals(false, bitManipulation.getBit(num, 4));
    }

    @Test
    public void setBitTest() {
        int num = 10000;
        BitManipulation bitManipulation = new BitManipulation();

        assertEquals(10001, bitManipulation.setBit(num, 0));
    }

    @Test
    public void clearBitTest() {
        int num = 10001;
        BitManipulation bitManipulation = new BitManipulation();

        assertEquals(10000, bitManipulation.clearBit(num, 0));
    }

    @Test
    public void clearBitFromMStoIndex() {
        int num = 10010101;
        BitManipulation bitManipulation = new BitManipulation();

        assertEquals(5, bitManipulation.clearFromMStoIndex(num, 3));
    }

    @Test
    public void updateBitOnIndex() {
        int num = 9;
        BitManipulation bitManipulation = new BitManipulation();

        assertEquals(11, bitManipulation.updateBitOnIndex(num, 1, 1));
    }
}
