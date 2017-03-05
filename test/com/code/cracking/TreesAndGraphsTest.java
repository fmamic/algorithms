package com.code.cracking;

import static org.junit.Assert.assertEquals;

import com.basic.framework.structures.BinaryTree;
import com.code.cracking.exercise.TreesAndGraphs;
import org.junit.Test;

public class TreesAndGraphsTest {

    @Test
    public void checkIfItIsBinaryTreeTest() {

        final BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();

        binaryTree.insert(45);
        binaryTree.insert(11);
        binaryTree.insert(18);
        binaryTree.insert(5);
        binaryTree.insert(53);

        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();

        assertEquals(false, treesAndGraphs.checkIfBinarySearchTree(binaryTree));

        final BinaryTree<Integer> binaryTree2 = new BinaryTree<Integer>();

        binaryTree2.insert(45);
        binaryTree2.insert(11);
        binaryTree2.insert(18);
        binaryTree2.insert(5);
        binaryTree2.insert(13);

        assertEquals(false, treesAndGraphs.checkIfBinarySearchTree(binaryTree2));

        final BinaryTree<Integer> binaryTree3 = new BinaryTree<Integer>();

        binaryTree3.insert(45);
        binaryTree3.insert(11);
        binaryTree3.insert(55);
        binaryTree3.insert(5);
        binaryTree3.insert(13);

        assertEquals(true, treesAndGraphs.checkIfBinarySearchTree(binaryTree3));
    }

}
