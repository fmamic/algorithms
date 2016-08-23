package com.basic.framework.structures;

class BinarySearchTree<T extends Comparable<T>> extends SearchTree<T> {

    private Node<T> root;

    BinarySearchTree(final T data) {
        super(data);
    }

    @Override
    public T insert(final T data) {
        Node<T> node = getRoot();

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
            }
            else {
                current = current.left;
            }
        }

        if (parent.getData().compareTo(data) < 0) {
            parent.right = new Node<T>(data, parent, null, null);
        }
        else {
            parent.left = new Node<T>(data, parent, null, null);
        }

        return data;
    }

    @Override
    public boolean search(final T data) {
        return treeSearch(getRoot(), data) != null;
    }

    @Override
    public T minimum() {
        return treeMinimum(getRoot()).getData();
    }

    @Override
    public T maximum() {
        return treeMaximum(getRoot()).getData();
    }

    @Override
    public T successor(final T data) {
        return treeSuccessor(treeSearch(getRoot(), data)).getData();
    }

    @Override
    public T predecessor(final T data) {
        return treePredecessor(treeSearch(getRoot(), data)).getData();
    }

    @Override
    public void delete(T data) {
        Node<T> node = treeSearch(getRoot(), data);

        if (node.left == null && node.right == null) {
            if (node.parent.left.equals(node)) {
                node.parent.left = null;
            }
            else {
                node.parent.right = null;
            }
            return;
        }

        if (node.left != null && node.right == null) {
            node.parent.left = node.left;
            return;
        }

        if (node.left == null) {
            node.parent.right = node.right;
            return;
        }

        Node<T> minimum = treeMinimum(node.right);

        if (minimum.parent != node) {
            transplant(minimum, minimum.right);
            minimum.right = node.right;
            minimum.right.parent = minimum;
        }

        transplant(node, minimum);
        minimum.left = node.left;
        minimum.left.parent = minimum;
    }

    @Override
    protected void initRoot(final T data) {
        setRoot(new Node<T>(data, null, null, null));
    }

    Node<T> treeMinimum(final Node<T> node) {
        Node<T> current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    private void transplant(final Node<T> first, final Node<T> second) {
        if (first.parent == null) {
            setRoot(second);
        }
        else if (first == first.parent.left) {
            first.parent.left = second;
        }
        else {
            first.parent.right = second;
        }

        if (second != null) {
            second.parent = first.parent;
        }
    }

    Node<T> treeSuccessor(final Node<T> node) {
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

    Node<T> treePredecessor(final Node<T> node) {
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

    Node<T> treeSearch(final Node<T> node, final T data) {
        if (node == null) {
            return null;
        }

        if (node.getData().compareTo(data) == 0) {
            return node;
        }

        if (node.getData().compareTo(data) < 0) {
            return treeSearch(node.right, data);
        }
        else {
            return treeSearch(node.left, data);
        }
    }

    Node<T> treeMaximum(final Node<T> node) {
        Node<T> current = node;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    Node<T> getRoot() {
        return this.root;
    }

    void setRoot(final Node<T> node) {
        this.root = node;
    }
}
