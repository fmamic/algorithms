package com.basic.framework.structures;

public class RedBlackTree<T extends Comparable<T>> extends SearchTree<T> {

    private Node<T> root;

    public RedBlackTree(final T data) {
        super(data);
    }

    private void leftRotate(final Node<T> node) {

    }

    private void rightRotate(final Node<T> node) {
        if (node.getNodeLeft() != null) {
            final Node<T> rotate = node.getNodeLeft();

            node.setNodeLeft(rotate.getNodeRight());
            rotate.setNodeRight(node);

            if (node.getParent() == null) {
                this.root = rotate;
            }
            else if (node.getParent().getNodeLeft().equals(node)) {
                node.getParent().setNodeLeft(rotate);
            }
            else {
                node.getParent().setNodeRight(rotate);
            }

            rotate.setParent(node.getParent());
            node.setParent(rotate);
        }
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

        public enum COLOR {
            RED,
            BLACK
        }

        public Node(final T data, final SearchTree.Node<T> parent, final SearchTree.Node<T> left, final SearchTree.Node<T> right) {
            super(data, parent, left, right);
        }

        public COLOR getColor() {
            return color;
        }

        public void setColor(final COLOR color) {
            this.color = color;
        }

        public Node<T> getNodeLeft() {
            return (Node<T>) this.left;
        }

        public Node<T> getNodeRight() {
            return (Node<T>) this.right;
        }

        public Node<T> getParent() {
            return (Node<T>) this.parent;
        }

        public void setParent(final Node<T> node) {
            this.parent = node;
        }

        public void setNodeLeft(final Node<T> node) {
            this.left = node;
        }

        public void setNodeRight(final Node<T> node) {
            this.right = node;
        }
    }
}
