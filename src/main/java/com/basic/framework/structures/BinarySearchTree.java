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
        Node<T> current = node;

        while (current != null) {
            parent = current;
            if (current.getData().compareTo(data) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (parent.getData().compareTo(data) < 0) {
            parent.right = new Node<T>(data, parent, null, null);
        } else {
            parent.left = new Node<T>(data, parent, null, null);
        }

        return data;
    }

    @Override
    public boolean search(final T data) {
        return recursiveSearch(this.root, data) != null;
    }

    @Override
    public T minimum() {
        return treeMinimum(this.root).getData();
    }

    @Override
    public T maximum() {
        return treeMaximum(this.root).getData();
    }

    @Override
    public T successor(final T data) {
        return treeSuccessor(recursiveSearch(this.root, data)).getData();
    }

    @Override
    public T predecessor(final T data) {
        return treePredecessor(recursiveSearch(this.root, data)).getData();
    }

    private Node<T> treeSuccessor(final Node<T> node) {
        Node<T> current = node;

        if (current.right != null) {
            return treeMinimum(current.right);
        }

        Node<T> parent = current.parent;

        while (parent != null && parent.right == current) {
            current = parent;
            parent = parent.parent;
        }

        return parent;
    }

    private Node<T> treePredecessor(final Node<T> node) {
        Node<T> current = node;

        if (current.left != null) {
            return treeMaximum(current.left);
        }

        Node<T> parent = current.parent;

        while (parent != null && parent.left == current) {
            current = parent;
            parent = parent.parent;
        }

        return parent;
    }

    private Node<T> treeMaximum(final Node<T> node) {
        Node<T> current = node;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    private Node<T> treeMinimum(final Node<T> node) {
        Node<T> current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    private Node<T> recursiveSearch(final Node<T> node, final T data) {
        if (node == null) {
            return null;
        }

        if (node.getData().compareTo(data) == 0) {
            return node;
        }

        if (node.getData().compareTo(data) < 0) {
            return recursiveSearch(node.right, data);
        } else {
            return recursiveSearch(node.left, data);
        }
    }
}
