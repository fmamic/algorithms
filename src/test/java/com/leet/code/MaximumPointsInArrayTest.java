package com.leet.code;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumPointsInArrayTest {

    @Test
    public void MaximumPointsInArrayTest() {
        MaximumPointsInArray maximumPointsInArray = new MaximumPointsInArray();

        int[] input = new int[] {1,1,0,1,0,0,2,1,0,1,2,0};

        int[] output = maximumPointsInArray.maximumBobPoints(9, input);

        assertEquals(output.length, 12);
    }
}
