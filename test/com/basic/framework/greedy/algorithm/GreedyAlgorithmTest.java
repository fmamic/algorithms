package com.basic.framework.greedy.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.basic.framework.greedy.algorithm.structure.Item;

public class GreedyAlgorithmTest {

    @Test
    public void activitySelectionTest() {
        final ActivitySelection activitySelection = new ActivitySelection();

        final int[][] activities = new int[][] { { 1, 2 }, { 3, 7 }, { 5, 8 }, { 9, 11 } };
        final int[][] activities2 = new int[][] { { 1, 2 }, { 3, 4 }, { 0, 6 }, { 5, 7 }, { 8, 9 }, { 5, 9 } };

        // recursive naive
        assertEquals(3, activitySelection.calculateRecursive(activities, 0, 3));
        assertEquals(4, activitySelection.calculateRecursive(activities2, 0, 5));

        // dynamic
        assertEquals(3, activitySelection.calculateDP(activities));
        assertEquals(4, activitySelection.calculateDP(activities2));

        // greedy
        assertEquals(3, activitySelection.calculateGreedy(activities, 0, 3));
        assertEquals(4, activitySelection.calculateGreedy(activities2, 0, 5));

        // greedy without recursive
        assertEquals(3, activitySelection.calculateGreedyIter(activities));
        assertEquals(4, activitySelection.calculateGreedyIter(activities2));
    }

    @Test
    public void fractionalKnapsackTest() {
        final FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();

        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));

        assertEquals(240, fractionalKnapsack.calculateGreedy(items, 50));
    }

}
