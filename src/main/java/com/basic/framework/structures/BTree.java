package com.basic.framework.structures;

import java.util.List;
import java.util.ArrayList;

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

    @SuppressWarnings("unchecked")
    public void insert(final T key) {

    }

    @SuppressWarnings("unchecked")
    void splitChild(final BTreeNode parent, final int index) {
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
