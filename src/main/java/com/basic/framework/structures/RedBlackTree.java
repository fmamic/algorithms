package com.basic.framework.structures;

public class RedBlackTree<T extends Comparable<T>> extends SearchTree<T> {

    public RedBlackTree(final T data) {
        super(data);
    }

    @Override
    public T insert(final T data) {
        return null;
    }

    @Override
    public boolean search(final T data) {
        return false;
    }

    @Override
    public T minimum() {
        return null;
    }

    @Override
    public T maximum() {
        return null;
    }

    @Override
    public T successor(final T data) {
        return null;
    }

    @Override
    public T predecessor(final T data) {
        return null;
    }

    @Override
    public void delete(final T data) {

    }

    @Override
    protected void initRoot(final T data) {

    }

    protected static class Node<T extends Comparable<T>> extends SearchTree.Node<T> {

        private COLOR color = COLOR.RED;

        public COLOR getColor() {
            return color;
        }

        public void setColor(final COLOR color) {
            this.color = color;
        }

        public enum COLOR {
            RED,
            BLACK
        }

        public Node(final T data, final SearchTree.Node<T> parent, final SearchTree.Node<T> left, final SearchTree.Node<T> right) {
            super(data, parent, left, right);
        }
    }
}
