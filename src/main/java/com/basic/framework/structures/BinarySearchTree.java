package com.basic.framework.structures;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

    public BinarySearchTree(final T data) {
        super(data);
    }

    @Override
    public T insert(final T data) {
        Node<T> node = this.root;

        if (node == null) {
            initRoot(data);
            return data;
        }

        Node<T> parent = null;

        while (node != null) {
            parent = node.parent;
            if (node.getData().compareTo(data) > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (parent.getData().compareTo(data) > 0) {
            parent.right = new Node<T>(data, parent, null, null);
        } else {
            parent.left = new Node<T>(data, parent, null, null);
        }

        return data;
    }
}
