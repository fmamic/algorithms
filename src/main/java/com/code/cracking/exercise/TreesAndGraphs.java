package com.code.cracking.exercise;

import com.basic.framework.structures.BinaryTree;

import com.basic.framework.structures.BinaryTree.BinaryTreeNode;
import com.basic.framework.structures.PriorityQueue;
import com.basic.framework.structures.Stack;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public class TreesAndGraphs {

    /**
     * 4.1.
     * Check if a binary tree is balanced (height no more then one difference between subtrees).
     * Solution: O(nlogn) time and O(n) space because of HashMap with n nodes.
     */
    public boolean isBinaryTreeBalanced(final BinaryTree binaryTree) {
        final int result = breadthFirstSearchBT(binaryTree);

        return !(result > 1);
    }

    // worst case O(nLogn), best case O(logn), space complexity O(n)
    private int breadthFirstSearchBT(final BinaryTree<Integer> binaryTree) {
        final PriorityQueue<BinaryTreeNode<Integer>> queue = new PriorityQueue<BinaryTreeNode<Integer>>();

        BinaryTreeNode<Integer> node = binaryTree.getRoot();

        final HashMap<BinaryTreeNode, Integer> distanceMap = new HashMap<BinaryTreeNode, Integer>();
        distanceMap.put(node, 0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        queue.insert(node);

        while (queue.getSize() != 0) { // n times where n is number of nodes
            node = queue.extractMin(); // O(log n)

            if (node.getLeft() != null) {
                queue.insert(node.getLeft()); // O(log n)
                distanceMap.put(node.getLeft(), distanceMap.get(node) + 1);
            }
            if (node.getRight() != null) {
                queue.insert(node.getRight()); // O(log n)
                distanceMap.put(node.getRight(), distanceMap.get(node) + 1);
            }

            if (node.getLeft() == null && node.getRight() == null) {
                if (distanceMap.get(node) < min) {
                    min = distanceMap.get(node);
                }

                if (distanceMap.get(node) > max) {
                    max = distanceMap.get(node);
                }
            }

            if (max - min > 1) {
                return max - min;
            }
        }

        return max - min;
    }

    /**
     * 4.5
     * Implement a function to check if binary tree is binary search tree.
     */
    public boolean checkIfBinarySearchTree(final BinaryTree binaryTree) {
        BinaryTreeNode node = binaryTree.getRoot();

        final Stack<BinaryTreeNode> stack = new Stack();

        BinaryTreeNode min = null;
        BinaryTreeNode max = null;

        while (!stack.isEmpty() || node != null) {

            if (node != null) {
                if (!compareNodes(node, max, min))
                    return false;

                stack.push(node);
                max = node;
                node = node.getLeft();
            } else {
                BinaryTreeNode nodePop = stack.pop();
                min = nodePop;
                max = stack.look();
                node = nodePop.getRight();
            }
        }

        return true;
    }

    private boolean compareNodes(final BinaryTreeNode node, final BinaryTreeNode max, final BinaryTreeNode min) {

        if (max != null && node.getData().compareTo(max.getData()) > 0) {
            return false;
        } else if (min != null && node.getData().compareTo(min.getData()) <= 0) {
            return false;
        }

        return true;
    }

}
