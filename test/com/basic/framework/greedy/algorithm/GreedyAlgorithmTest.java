package com.basic.framework.greedy.algorithm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.basic.framework.greedy.algorithm.structure.HuffmanItem;
import com.basic.framework.greedy.algorithm.structure.Item;
import com.basic.framework.structures.BinaryTree;

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

    @Test
    public void huffmanCodeTest() {
        final HuffmanCode huffmanCode = new HuffmanCode();

        final List<HuffmanItem> huffmanItems = new ArrayList<HuffmanItem>();

        huffmanItems.add(new HuffmanItem("a", 45));
        huffmanItems.add(new HuffmanItem("b", 13));
        huffmanItems.add(new HuffmanItem("c", 12));
        huffmanItems.add(new HuffmanItem("d", 16));
        huffmanItems.add(new HuffmanItem("e", 9));
        huffmanItems.add(new HuffmanItem("f", 5));

        final BinaryTree.BinaryTreeNode node = huffmanCode.huffman(huffmanItems);

        assertEquals(null, node);
    }

}
