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
        return rbSearch(root, data) != null;
    }

    private Node<T> rbSearch(final Node<T> node, final T data) {
        final Node<T> sentinel = createSentinel();

        if (node.equals(sentinel)) {
            return null;
        } else if (node.getData().equals(data)) {
            return node;
        }

        if (node.getData().compareTo(data) > 0) {
            return rbSearch(node.getNodeLeft(), data);
        } else {
            return rbSearch(node.getNodeRight(), data);
        }
    }

    @Override
    public T minimum() {
        return treeMinimum(this.root).getData();
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

    private Node<T> rbInsert(final Node<T> node) {
        Node<T> root = this.root;
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
            this.root = node;
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

        this.root.setColor(Node.COLOR.BLACK);
    }

    private void leftRotate(final Node<T> node) {
        if (node.getNodeRight() != null) {
            final Node<T> rotate = node.getNodeRight();

            node.setNodeRight(rotate.getNodeLeft());
            rotate.setNodeLeft(node);

            if (node.getNodeRight() != null) {
                node.getNodeRight().setParent(node);
            }

            if (node.getParent() == null) {
                this.root = rotate;
            } else if (node.getParent().getNodeLeft().equals(node)) {
                node.getParent().setNodeLeft(rotate);
            } else {
                node.getParent().setNodeRight(rotate);
            }

            rotate.setParent(node.getParent());
            node.setParent(rotate);
        }
    }

    private void rightRotate(final Node<T> node) {
        if (node.getNodeLeft() != null) {
            final Node<T> rotate = node.getNodeLeft();

            node.setNodeLeft(rotate.getNodeRight());
            rotate.setNodeRight(node);

            if (node.getParent() == null) {
                this.root = rotate;
            } else if (node.getParent().getNodeLeft().equals(node)) {
                node.getParent().setNodeLeft(rotate);
            } else {
                node.getParent().setNodeRight(rotate);
            }

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
            root = second;
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
        this.root = new Node<T>(data, null, createSentinel(), createSentinel());
        this.root.setColor(Node.COLOR.BLACK);
    }

    Node<T> treeMinimum(final SearchTree.Node<T> node) {
        Node<T> current = (Node<T>) node;

        while (!current.getNodeLeft().equals(createSentinel())) {
            current = current.getNodeLeft();
        }

        return current;
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
