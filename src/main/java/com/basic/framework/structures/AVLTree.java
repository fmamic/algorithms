package com.basic.framework.structures;

class AVLTree<T extends Comparable<T>> extends SearchTree<T> {

    private Node<T> root;

    AVLTree(final T data) {
        super(data);
    }

    public T insert(final T data) {
        Node<T> node = getRoot();

        if (data == null)
            return null;

        Node<T> parent = node;
        while (!node.equals(sentinel())) {
            if (node.getData().compareTo(data) > 0) {
                if (node.getNodeLeft().getHeight() + 1 == node.getHeight()) {
                    node.setHeight(node.getHeight() + 1);
                }
                parent = node;
                node = node.getNodeLeft();
            } else {
                if (node.getNodeRight().getHeight() + 1 == node.getHeight()) {
                    node.setHeight(node.getHeight() + 1);
                }
                parent = node;
                node = node.getNodeRight();
            }
        }

        node.setNodeLeft(sentinel());
        node.setNodeRight(sentinel());
        node.setData(data);
        node.setHeight(1);
        node.setParent(parent);

        balanceTree(node.getParent());

        return data;
    }

    private void balanceTree(final Node<T> node) {
        Node<T> iterator = node;
        while (iterator != null && !iterator.equals(sentinel())) {
            int leftHeight = iterator.getNodeLeft().getHeight();
            int rightHeight = iterator.getNodeRight().getHeight();

            if (Math.abs(leftHeight - rightHeight) > 1) {
                if (leftHeight > rightHeight) {
                    rightRotate(iterator);
                } else {
                    leftRotate(iterator);
                }
            }
            iterator = iterator.getParent();
        }
    }

    private void rightRotate(final Node<T> iterator) {
        Node<T> rotate = iterator.getNodeLeft();

        rotate.setParent(iterator.getParent());

        if (iterator.getParent().getNodeLeft().equals(iterator)) {
            iterator.getParent().setNodeLeft(rotate);
        } else {
            iterator.getParent().setNodeRight(rotate);
        }

        iterator.setNodeLeft(rotate.getNodeRight());
        iterator.getNodeLeft().setParent(iterator);
        iterator.setParent(rotate);

        rotate.setNodeRight(iterator);

        iterator.setHeight(iterator.getNodeLeft().getHeight() + 1);

        setMaxHeight(rotate.getNodeLeft());
        setMaxHeight(rotate.getNodeRight());

        fixHeight(rotate);
    }

    private void setMaxHeight(final Node<T> node) {
        final int leftHeight = node.getNodeLeft().getHeight();
        final int rightHeight = node.getNodeRight().getHeight();

        if (leftHeight > rightHeight) {
            node.setHeight(leftHeight + 1);
        } else {
            node.setHeight(rightHeight + 1);
        }
    }

    private void fixHeight(Node<T> iterator) {
        Node<T> node = iterator.getParent();

        while (!node.equals(sentinel())) {
            setMaxHeight(node);
            node = node.getParent();
        }
    }

    private void leftRotate(final Node<T> iterator) {
        Node<T> rotate = iterator.getNodeRight();

        rotate.setParent(iterator.getParent());

        if (iterator.getParent().getNodeLeft().equals(iterator)) {
            iterator.getParent().setNodeLeft(rotate);
        } else {
            iterator.getParent().setNodeRight(rotate);
        }

        iterator.setNodeRight(rotate.getNodeLeft());
        rotate.setNodeLeft(iterator);
        iterator.setParent(rotate);

        iterator.getNodeRight().setParent(iterator);

        setMaxHeight(rotate.getNodeLeft());
        setMaxHeight(rotate.getNodeRight());

        fixHeight(rotate);
    }

    public boolean search(final T data) {
        return false;
    }

    public void delete(final T data) {

    }

    protected void initRoot(final T data) {
        final Node<T> left = sentinel();
        final Node<T> right = sentinel();

        this.root = new Node<T>(sentinel(), left, right, data, 1);

        left.setParent(this.root);
        right.setParent(this.root);
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
        private int height = 0;

        Node(final Node<T> parent, final Node<T> left, final Node<T> right, final T data, final int height) {
            super(data, parent, left, right);
            this.height = height;
        }

        int getHeight() {
            return height;
        }

        void setHeight(final int height) {
            this.height = height;
        }

        void incHeight() {
            this.height++;
        }

        Node<T> getNodeLeft() {
            return (Node<T>) this.left;
        }

        void setNodeLeft(final Node<T> node) {
            this.left = node;
        }

        Node<T> getNodeRight() {
            return (Node<T>) this.right;
        }

        void setNodeRight(final Node<T> node) {
            this.right = node;
        }

        Node<T> getParent() {
            return (Node<T>) this.parent;
        }

        void setParent(final Node<T> node) {
            this.parent = node;
        }
    }
}
