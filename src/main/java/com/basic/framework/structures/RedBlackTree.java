package com.basic.framework.structures;

class RedBlackTree<T extends Comparable<T>> extends SearchTree<T> {

    private Node<T> root;

    RedBlackTree(final T data) {
        super(data);
    }

    @Override
    public T insert(final T data) {
        return rbInsert(createSentinel(data)).getData();
    }

    @Override
    public boolean search(final T data) {
        return treeSearch(getRoot(), data) != null;
    }

    Node<T> treeSearch(final SearchTree.Node<T> node, final T data) {
        final Node<T> sentinel = createSentinel();
        final Node<T> current = (Node<T>) node;

        if (current.equals(sentinel)) {
            return null;
        } else if (current.getData().equals(data)) {
            return current;
        }

        if (current.getData().compareTo(data) > 0) {
            return treeSearch(current.getNodeLeft(), data);
        } else {
            return treeSearch(current.getNodeRight(), data);
        }
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
    public void delete(final T data) {

    }

    private Node<T> rbInsert(final Node<T> node) {
        Node<T> root = getRoot();
        Node<T> nil = createSentinel();
        Node<T> parent = createSentinel();

        while (!root.equals(nil)) {
            parent = root;
            if (root.getData().compareTo(node.getData()) > 0) {
                root = root.getNodeLeft();
            } else {
                root = root.getNodeRight();
            }
        }

        node.setParent(parent);

        if (parent.equals(nil)) {
            setRoot(node);
        } else if (parent.getData().compareTo(node.getData()) > 0) {
            parent.setNodeLeft(node);
        } else {
            parent.setNodeRight(node);
        }

        node.setNodeLeft(createSentinel());
        node.setNodeRight(createSentinel());
        node.setColor(Node.COLOR.RED);

        rbRearrange(node);

        return node;
    }

    private void rbRearrange(final Node<T> node) {
        Node<T> param = node;

        while (param.getParent() != null && param.getParent().getColor().equals(Node.COLOR.RED)) {
            if (param.getParent().equals(param.getGrandParentLeft())) {
                Node<T> uncle = param.getGrandParentRight();

                if (uncle.getColor().equals(Node.COLOR.RED)) {
                    param.getParent().setColor(Node.COLOR.BLACK);
                    uncle.setColor(Node.COLOR.BLACK);
                    param.getGrandParent().setColor(Node.COLOR.RED);
                    param = param.getGrandParent();
                } else {
                    if (param.equals(param.getParent().getNodeRight())) {
                        param = param.getParent();
                        leftRotate(param);
                    }
                    param.getParent().setColor(Node.COLOR.BLACK);
                    param.getGrandParent().setColor(Node.COLOR.RED);
                    rightRotate(param.getGrandParent());
                }
            } else {
                Node<T> uncle = param.getGrandParentLeft();

                if (uncle.getColor().equals(Node.COLOR.RED)) {
                    param.getParent().setColor(Node.COLOR.BLACK);
                    uncle.setColor(Node.COLOR.BLACK);
                    param.getGrandParent().setColor(Node.COLOR.RED);
                    param = param.getGrandParent();
                } else {
                    if (param.equals(param.getParent().getNodeLeft())) {
                        param = param.getParent();
                        rightRotate(param);
                    }
                    param.getParent().setColor(Node.COLOR.BLACK);
                    param.getGrandParent().setColor(Node.COLOR.RED);
                    leftRotate(param.getGrandParent());
                }
            }
        }

        getRoot().setColor(Node.COLOR.BLACK);
    }

    private void leftRotate(final Node<T> node) {
        if (node.getNodeRight() != null) {
            final Node<T> rotate = node.getNodeRight();

            node.setNodeRight(rotate.getNodeLeft());
            rotate.setNodeLeft(node);

            if (node.getNodeRight() != null) {
                node.getNodeRight().setParent(node);
            }

            rotate(node, rotate);

            rotate.setParent(node.getParent());
            node.setParent(rotate);
        }
    }

    private void rotate(final Node<T> node, final Node<T> rotate) {
        if (node.getParent() == null) {
            setRoot(rotate);
        } else if (node.getParent().getNodeLeft().equals(node)) {
            node.getParent().setNodeLeft(rotate);
        } else {
            node.getParent().setNodeRight(rotate);
        }
    }

    private void rightRotate(final Node<T> node) {
        if (node.getNodeLeft() != null) {
            final Node<T> rotate = node.getNodeLeft();

            node.setNodeLeft(rotate.getNodeRight());
            rotate.setNodeRight(node);

            rotate(node, rotate);

            rotate.setParent(node.getParent());
            node.setParent(rotate);

            if (node.getNodeLeft() != null) {
                node.getNodeLeft().setParent(node);
            }
        }
    }

    private void transplant(final Node<T> first, final Node<T> second) {
        final Node<T> sentinel = createSentinel();

        if (first.getParent().equals(sentinel)) {
            setRoot(second);
        } else if (first.getParent().getNodeLeft().equals(first)) {
            first.getParent().setNodeLeft(second);
        } else {
            first.getParent().setNodeRight(second);
        }

        second.setParent(first.getParent());
    }

    private Node<T> createSentinel(final T data) {
        final Node<T> sentinel = new Node<T>(data, null, null, null);
        sentinel.setColor(Node.COLOR.BLACK);

        return sentinel;
    }

    private Node<T> createSentinel() {
        final Node<T> sentinel = new Node<T>(null, null, null, null);
        sentinel.setColor(Node.COLOR.BLACK);

        return sentinel;
    }

    @Override
    protected void initRoot(final T data) {
        setRoot(new Node<T>(data, null, createSentinel(), createSentinel()));
        getRoot().setColor(Node.COLOR.BLACK);
    }

    Node<T> treeMinimum(final SearchTree.Node<T> node) {
        Node<T> current = (Node<T>) node;

        while (!current.getNodeLeft().equals(createSentinel())) {
            current = current.getNodeLeft();
        }

        return current;
    }

    Node<T> treeMaximum(final SearchTree.Node<T> node) {
        Node<T> current = (Node<T>) node;

        while (!current.getNodeRight().equals(createSentinel())) {
            current = current.getNodeRight();
        }

        return current;
    }

    Node<T> treeSuccessor(final SearchTree.Node<T> node) {
        Node<T> current = (Node<T>) node;

        if (!current.getNodeRight().equals(createSentinel())) {
            return treeMinimum(current.right);
        }

        Node<T> parent = current.getParent();

        while (!parent.equals(createSentinel()) && parent.getNodeRight().equals(current)) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    Node<T> treePredecessor(final SearchTree.Node<T> node) {
        Node<T> current = (Node<T>) node;

        if (!current.getNodeLeft().equals(createSentinel())) {
            return treeMaximum(current.getNodeLeft());
        }

        Node<T> parent = current.getParent();

        while (!parent.equals(createSentinel()) && parent.getNodeLeft().equals(current)) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    Node<T> getRoot() {
        return this.root;
    }

    void setRoot(final Node<T> node) {
        this.root = node;
    }

    private static class Node<T extends Comparable<T>> extends SearchTree.Node<T> {

        private COLOR color = COLOR.RED;

        enum COLOR {
            RED,
            BLACK
        }

        Node(final T data, final SearchTree.Node<T> parent, final SearchTree.Node<T> left, final SearchTree.Node<T> right) {
            super(data, parent, left, right);
        }

        COLOR getColor() {
            return color;
        }

        void setColor(final COLOR color) {
            this.color = color;
        }

        Node<T> getNodeLeft() {
            return (Node<T>) this.left;
        }

        Node<T> getNodeRight() {
            return (Node<T>) this.right;
        }

        Node<T> getParent() {
            return (Node<T>) this.parent;
        }

        void setParent(final Node<T> node) {
            this.parent = node;
        }

        void setNodeLeft(final Node<T> node) {
            this.left = node;
        }

        void setNodeRight(final Node<T> node) {
            this.right = node;
        }

        Node<T> getGrandParent() {
            return this.getParent().getParent();
        }

        Node<T> getGrandParentLeft() {
            return this.getParent().getParent().getNodeLeft();
        }

        Node<T> getGrandParentRight() {
            return this.getParent().getParent().getNodeRight();
        }
    }
}
