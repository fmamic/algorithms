package com.basic.framework.structures;

import java.util.List;
import java.util.ArrayList;

/**
 * BTree node implementation mainly for use in HDD where disk access is very costly. Preforms DISK_WRITE(x) and DISK_READ(x).
 * Root Node is always in the primary memory.
 */
public class BTree<T extends Comparable> {

    private BTreeNode root;

    private final int minimumDegree;

    public BTree() {
        this.minimumDegree = 2;
    }

    public BTree(int minimumDegree) {
        this.minimumDegree = minimumDegree;
    }

    @SuppressWarnings("unchecked")
    BTreeNode search(final BTreeNode node, final T key) {
        int index = 0;
        while (index < node.numberOfKeys && key.compareTo(node.keys.get(index)) > 0) {
            index++;
        }

        if (key.compareTo(node.keys.get(index)) == 0) {
            return node;
        } else if (node.leaf) {
            return null;
        } else {
            return search((BTreeNode) node.children.get(index), key);
        }
    }

    /**
     * Inserting key into B Tree takes O(h) disk access where h is height of tree.
     * It is inserting in single pass and splitting full nodes on the way to the correct position in the tree.
     */
    public void insert(final T key) {
        if (root == null)
            root = create();

        insertNode(root, key);
    }

    @SuppressWarnings("unchecked")
    private void insertNode(final BTreeNode root, final T key) {
        final BTreeNode current = root;
        if (current.numberOfKeys == 2 * minimumDegree - 1) {
            BTreeNode parent = create();
            parent.leaf = false;
            parent.children.add(current);
            this.root = parent;

            splitChild(parent, 1);
            insertNonFull(parent, key);
        } else {
            insertNonFull(current, key);
        }
    }

    @SuppressWarnings("unchecked")
    private void insertNonFull(final BTreeNode node, final T key) {
        if (node.leaf) {
            int index = 0;
            while (((T) node.keys.get(index)).compareTo(key) < 0) {
                index++;
            }
            node.keys.add(index, key);
            node.numberOfKeys++;
        } else {
            int index = 0;
            while (((T) node.keys.get(index)).compareTo(key) < 0) {
                index++;
            }

            if (((BTreeNode) node.children.get(index)).numberOfKeys == minimumDegree * 2 - 1) {
                splitChild(node, index);
                if (((T) node.keys.get(index)).compareTo(key) < 0) {
                    index++;
                }
                insertNonFull((BTreeNode) node.children.get(index), key);
            }
        }
    }

    /**
     * This method is splitting full nodes into two nodes with minimumDegree - 1 number of keys and it is setting up new root node.
     * Three disk writes are needed for writing right, left and parent node.
     */
    @SuppressWarnings("unchecked")
    private void splitChild(final BTreeNode parent, final int index) {
        final BTreeNode rightNode = create();
        final BTreeNode leftNode = (BTreeNode) parent.children.get(index);

        rightNode.leaf = leftNode.leaf;
        rightNode.numberOfKeys = minimumDegree - 1;

        for (int i = minimumDegree + 1; i <= minimumDegree * 2 + 1; i++) {
            rightNode.keys.add(leftNode.keys.get(i));
            leftNode.keys.remove(minimumDegree + 1);
        }

        if (!leftNode.leaf) {
            for (int i = minimumDegree; i <= minimumDegree * 2; i++) {
                rightNode.children.add(leftNode.children.get(i));
                leftNode.children.remove(minimumDegree);
            }
        }

        leftNode.numberOfKeys = minimumDegree - 1;

        parent.children.add(index + 1, rightNode);
        parent.keys.set(index, leftNode.keys.get(minimumDegree));
        parent.numberOfKeys++;
    }

    private BTreeNode create() {
        final BTreeNode node = new BTreeNode();
        node.keys = new ArrayList<T>();
        return node;
    }

    private static class BTreeNode<T extends Comparable> {

        private int numberOfKeys = 0;

        private boolean leaf = true;

        private List<T> keys;

        private ArrayList<BTreeNode> children;

        void incrementNumberOfKeys(final int minimumDegree) {
            this.numberOfKeys++;
            if (this.numberOfKeys == minimumDegree - 1) {
                this.leaf = true;
                children = new ArrayList<BTreeNode>();
            }
        }
    }
}
