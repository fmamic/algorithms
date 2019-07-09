package com.basic.framework.structures;

import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void inOrderTraversalTest() {
        final BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        tree.insert(15);
        tree.insert(10);
        tree.insert(25);
        tree.insert(5);

        tree.inOrderTraversal(tree.getRoot());
    }

    @Test
    public void preOrderTraversalTest() {
        final BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        tree.insert(15);
        tree.insert(10);
        tree.insert(25);
        tree.insert(5);

        tree.preOrderTraversal(tree.getRoot());
    }

    @Test
    public void postOrderTraversalTest() {
        final BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        tree.insert(15);
        tree.insert(10);
        tree.insert(25);
        tree.insert(5);

        tree.postOrderTraversal(tree.getRoot());
    }
}
