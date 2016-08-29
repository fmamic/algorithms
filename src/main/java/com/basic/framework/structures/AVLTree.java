package com.basic.framework.structures;

class AVLTree<T extends Comparable<T>> extends SearchTree<T> {

    private Node<T> root;

    public AVLTree(final T data) {
        super(data);
    }

    public T insert(final T data) {
        return null;
    }

    public boolean search(final T data) {
        return false;
    }

    public void delete(final T data) {

    }

    protected void initRoot(final T data) {

    }

    Node<T> treeMinimum(final SearchTree.Node<T> node) {
        return null;
    }

    Node<T> treeMaximum(final SearchTree.Node<T> node) {
        return null;
    }

    Node<T> treeSuccessor(final SearchTree.Node<T> data) {
        return null;
    }

    Node<T> treePredecessor(final SearchTree.Node<T> data) {
        return null;
    }

    Node<T> treeSearch(final SearchTree.Node<T> node, final T data) {
        return null;
    }

    Node<T> getRoot() {
        return this.root;
    }

    private Node<T> sentinel() {
        return new Node<T>(null, null, null, null, 0);
    }

    class Node<T extends Comparable<T>> extends SearchTree.Node<T> {
        private int height;

        Node(final Node<T> parent, final Node<T> left, final Node<T> right, final T data, final int height) {
            super(data, parent, left, right);
            this.height = height;
        }

        int getHeight() {
            return height;
        }
    }
}
