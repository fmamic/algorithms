package com.code.cracking.exercise;

import com.basic.framework.structures.BinaryTree;

import com.basic.framework.structures.BinaryTree.BinaryTreeNode;
import com.basic.framework.structures.Stack;

@SuppressWarnings("unchecked")
public class TreesAndGraphs {

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
