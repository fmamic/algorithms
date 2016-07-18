package com.basic.framework.structures;

public abstract class Tree<T extends Comparable<T>> {

    protected Node<T> root;

    public Tree(final T data) {
        initRoot(data);
    }

    public abstract T insert(final T data);

    public abstract boolean search(final T data);

    public abstract T minimum();

    public abstract T maximum();

    public abstract T successor(T data);

    public abstract T predecessor(T data);

    protected void initRoot(final T data) {
        this.root = new Node<T>(data, null, null, null);
    }

    protected static class Node<T extends Comparable<T>> {
        private T data;
        protected Node<T> parent;
        protected Node<T> left;
        protected Node<T> right;

        public T getData() {
            return this.data;
        }

        public Node(final T data, final Node<T> parent, final Node<T> left, final Node<T> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
