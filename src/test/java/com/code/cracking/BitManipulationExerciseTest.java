package com.code.cracking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitManipulationExerciseTest {

    @Test
    public void insertMintoNTest () {
        final BitManipulationExcercise bitManipulationExcercise = new BitManipulationExcercise();

        final int num1 = 1024;
        final int num2 = 19;

        assertEquals(1100, bitManipulationExcercise.insertMintoNnumber(num1, num2, 2, 6));
    }

}
