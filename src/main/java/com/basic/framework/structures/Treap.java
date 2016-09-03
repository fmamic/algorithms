package com.basic.framework.structures;

class Treap<T extends Comparable<T>, N extends Comparable<N>> extends SearchTree<T> {

    private Node<T, N> root;

    Treap(final T data, final N property) {
        super(data);
        this.root.setProperty(property);
    }

    T insert(final T data, final N property) {
        Node<T, N> iterator = getResultNode(data);

        iterator.setProperty(property);
        iterator.setData(data);
        iterator.setNodeLeft(createSentinel());
        iterator.setNodeRight(createSentinel());

        correctHeapProperty(iterator);

        return data;
    }

    private void correctHeapProperty(final Node<T, N> node) {
        Node<T, N> iterator = node;

        while (!iterator.getParent().equals(createSentinel()) && iterator.getProperty().compareTo(iterator.getParent().getProperty()) < 0) {
            if (iterator.getParent().getNodeLeft().equals(iterator)) {
                rightRotate(iterator.getParent());
            } else {
                leftRotate(iterator.getParent());
            }
        }
    }

    private void leftRotate(final Node<T, N> node) {
        node.getNodeRight().setParent(node.getParent());

        if (node.equals(this.root)) {
            this.root = node.getNodeRight();
        }
        if (node.getParent().getNodeLeft().equals(node)) {
            node.getParent().setNodeLeft(node.getNodeRight());
        } else {
            node.getParent().setNodeRight(node.getNodeRight());
        }

        node.setParent(node.getNodeRight());
        node.setNodeRight(node.getNodeRight().getNodeLeft());
        node.getParent().setNodeLeft(node);
        node.getNodeRight().setParent(node);
    }

    private void rightRotate(final Node<T, N> node) {
        node.getNodeLeft().setParent(node.getParent());

        if (node.equals(this.root)) {
            this.root = node.getNodeLeft();
        } else if (node.getParent().getNodeLeft().equals(node)) {
            node.getParent().setNodeLeft(node.getNodeLeft());
        } else {
            node.getParent().setNodeRight(node.getNodeLeft());
        }

        node.setParent(node.getNodeLeft());
        node.setNodeLeft(node.getNodeLeft().getNodeRight());
        node.getParent().setNodeRight(node);
        node.getNodeLeft().setParent(node);
    }

    private Node<T, N> getResultNode(T data) {
        Node<T, N> iterator = getRoot();
        final Node<T, N> sentinel = createSentinel();
        Node<T, N> parent = null;

        while (!iterator.equals(sentinel)) {
            if (iterator.getData().compareTo(data) > 0) {
                parent = iterator;
                iterator = iterator.getNodeLeft();
            } else {
                parent = iterator;
                iterator = iterator.getNodeRight();
            }
        }
        iterator.setParent(parent);
        return iterator;
    }

    public T insert(T data) {
        Node<T, N> iterator = getResultNode(data);

        iterator.setProperty(null);
        iterator.setData(data);
        iterator.setNodeLeft(createSentinel());
        iterator.setNodeRight(createSentinel());

        return data;
    }

    public boolean search(final T data) {
        return false;
    }

    public void delete(final T data) {

    }

    protected void initRoot(final T data) {
        this.root = new Node<T, N>(createSentinel(), createSentinel(), createSentinel(), data);
    }

    private Node<T, N> createSentinel() {
        final Node<T, N> sentinel = new Node<T, N>(null, null, null, null);
        sentinel.setProperty(null);
        return sentinel;
    }

    Node<T, N> treeMinimum(final SearchTree.Node<T> node) {
        return null;
    }

    Node<T, N> treeMaximum(final SearchTree.Node<T> node) {
        return null;
    }

    Node<T, N> treeSuccessor(final SearchTree.Node<T> data) {
        return null;
    }

    Node<T, N> treePredecessor(final SearchTree.Node<T> data) {
        return null;
    }

    Node<T, N> treeSearch(final SearchTree.Node<T> node, final T data) {
        return null;
    }

    Node<T, N> getRoot() {
        return this.root;
    }

    private class Node<K extends Comparable<K>, P extends Comparable> extends SearchTree.Node<K> {
        private P property;

        Node(final Node<K, P> parent, final Node<K, P> left, final Node<K, P> right, final K data) {
            super(data, parent, left, right);
        }

        Node<K, P> getNodeLeft() {
            return (Node<K, P>) this.left;
        }

        void setNodeLeft(final Node<K, P> node) {
            this.left = node;
        }

        Node<K, P> getNodeRight() {
            return (Node<K, P>) this.right;
        }

        void setNodeRight(final Node<K, P> node) {
            this.right = node;
        }

        Node<K, P> getParent() {
            return (Node<K, P>) this.parent;
        }

        void setParent(final Node<K, P> node) {
            this.parent = node;
        }

        P getProperty() {
            return property;
        }

        void setProperty(P property) {
            this.property = property;
        }
    }
}
