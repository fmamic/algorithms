package com.basic.framework.greedy.algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreedyAlgorithmTest {

    @Test
    public void activitySelectionTest() {
        final ActivitySelection activitySelection = new ActivitySelection();

        final int[][] activities = new int[][]{{1, 2}, {3, 7}, {5, 8}, {9, 11}};
        final int[][] activities2 = new int[][]{{1, 2}, {3, 4}, {0, 6}, {5, 7}, {8, 9}, {5, 9}};

        // recursive naive
        assertEquals(3, activitySelection.calculateRecursive(activities, 0, 3));
        assertEquals(4, activitySelection.calculateRecursive(activities2, 0, 5));

        // dynamic
        assertEquals(3, activitySelection.calculateDP(activities));
        assertEquals(4, activitySelection.calculateDP(activities2));
    }

}
