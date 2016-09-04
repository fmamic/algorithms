package com.basic.framework.structures;

/**
 * Red Black Tree with Order Statistic properties
 */
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
        final Node<T> result = treePredecessor(treeSearch(getRoot(), data));
        return result != null ? result.getData() : null;
    }

    T selectElement(final int i) {
        return selectElement(getRoot(), i).getData();
    }

    private Node<T> selectElement(final Node<T> node, final int i) {
        int size = node.getNodeLeft().getSize() + 1;

        if (size == i) {
            return node;
        }

        if (size < i) {
            return selectElement(node.getNodeRight(), i - size);
        } else {
            return selectElement(node.getNodeLeft(), i);
        }
    }

    int rankElement(final T data) {
        return rankElement(treeSearch(getRoot(), data));
    }

    private int rankElement(final Node<T> node) {
        int rank = node.getNodeLeft().getSize() + 1;

        Node<T> iterator = node;

        while (!iterator.equals(getRoot())) {
            if (iterator.getParent().getNodeRight().equals(iterator)) {
                rank += iterator.getParent().getNodeLeft().getSize() + 1;
            }
            iterator = iterator.getParent();
        }

        return rank;
    }

    @Override
    public void delete(final T data) {
        final Node<T> node = treeSearch(getRoot(), data);
        final Node<T> nil = createSentinel();

        Node<T> replace = node;
        Node<T> follow;
        Node.COLOR orgColor = replace.getColor();

        if (node.getNodeLeft().equals(nil)) {
            follow = node.getNodeRight();
            transplant(node, node.getNodeRight());
        } else if (node.getNodeRight().equals(nil)) {
            follow = node.getNodeLeft();
            transplant(node, node.getNodeLeft());
        } else {
            replace = treeSuccessor(node);
            orgColor = replace.getColor();
            follow = replace.getNodeRight();

            if (replace.getParent().equals(node)) {
                follow.setParent(replace);
            } else {
                transplant(replace, replace.getNodeRight());
                replace.setNodeRight(node.getNodeRight());
                replace.getNodeRight().setParent(replace);
            }

            transplant(node, replace);

            replace.setNodeLeft(node.getNodeLeft());
            replace.getNodeLeft().setParent(node);
            replace.setColor(node.getColor());
        }

        if (orgColor.equals(Node.COLOR.BLACK))
            rbTreeFix(follow);
    }

    void inorderPrint() {
        inorderPrint(this.root);
    }

    private void inorderPrint(final Node<T> node) {

        if (node.equals(createSentinel())) {
            return;
        }

        inorderPrint(node.getNodeLeft());

        System.out.println(node.getData());

        inorderPrint(node.getNodeRight());

    }

    private void rbTreeFix(final Node<T> param) {
        Node<T> follow = param;
        while (!follow.equals(getRoot()) && follow.getColor().equals(Node.COLOR.BLACK)) {
            if (follow.getParent() != null && follow.equals(follow.getParent().getNodeLeft())) {
                Node<T> sibling = follow.getParent().getNodeRight();
                if (sibling.getColor().equals(Node.COLOR.RED)) {
                    sibling.setColor(Node.COLOR.BLACK);
                    follow.getParent().setColor(Node.COLOR.RED);
                    leftRotate(follow.getParent());
                    sibling = follow.getParent().getNodeRight();
                }
                if (follow.getNodeLeft() != null && follow.getNodeLeft().getColor().equals(Node.COLOR.BLACK)
                        && follow.getNodeRight() != null && follow.getNodeRight().getColor().equals(Node.COLOR.BLACK)) {
                    sibling.setColor(Node.COLOR.RED);
                    follow = follow.getParent();
                } else if (sibling.getNodeRight() != null && sibling.getNodeRight().getColor().equals(Node.COLOR.BLACK)) {
                    sibling.getNodeLeft().setColor(Node.COLOR.BLACK);
                    sibling.setColor(Node.COLOR.RED);
                    rightRotate(sibling);
                    sibling = follow.getParent().getNodeRight();
                }

                sibling.setColor(follow.getParent().getColor());
                follow.getParent().setColor(Node.COLOR.BLACK);
                sibling.getNodeRight().setColor(Node.COLOR.BLACK);
                leftRotate(follow.getParent());
                follow = createSentinel();

            } else {
                if (follow.getParent() == null)
                    break;
                Node<T> sibling = follow.getParent().getNodeLeft();
                if (sibling.getColor().equals(Node.COLOR.RED)) {
                    sibling.setColor(Node.COLOR.BLACK);
                    follow.getParent().setColor(Node.COLOR.RED);
                    rightRotate(follow.getParent());
                    sibling = follow.getParent().getNodeLeft();
                }
                if (follow.getNodeRight() != null && follow.getNodeRight().getColor().equals(Node.COLOR.BLACK)
                        && follow.getNodeLeft() != null && follow.getNodeLeft().getColor().equals(Node.COLOR.BLACK)) {
                    sibling.setColor(Node.COLOR.RED);
                    follow = follow.getParent();
                } else if (sibling.getNodeLeft() != null && sibling.getNodeLeft().getColor().equals(Node.COLOR.BLACK)) {
                    sibling.getNodeRight().setColor(Node.COLOR.BLACK);
                    sibling.setColor(Node.COLOR.RED);
                    leftRotate(sibling);
                    sibling = follow.getParent().getNodeLeft();
                }

                sibling.setColor(follow.getParent().getColor());
                follow.getParent().setColor(Node.COLOR.BLACK);
                sibling.getNodeLeft().setColor(Node.COLOR.BLACK);
                rightRotate(follow.getParent());
                follow = createSentinel();
            }
        }
        follow.setColor(Node.COLOR.BLACK);
    }

    private Node<T> rbInsert(final Node<T> node) {
        Node<T> root = getRoot();
        Node<T> nil = createSentinel();
        Node<T> parent = createSentinel();

        while (!root.equals(nil)) {
            parent = root;
            if (root.getData().compareTo(node.getData()) > 0) {
                root.setSize(root.getSize() + 1);
                root = root.getNodeLeft();
            } else {
                root.setSize(root.getSize() + 1);
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
        node.setSize(1);

        rbRearrange(node);

        return node;
    }

    private void rbRearrange(final Node<T> node) {
        Node<T> param = node;

        while (param.getParent() != null && param.getParent().getColor().equals(Node.COLOR.RED)) {
            if (param.getParent().equals(param.getUncleLeft())) {
                Node<T> uncle = param.getUncleRight();

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
                Node<T> uncle = param.getUncleLeft();

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

            rotate.setSize(node.getSize());
            node.setSize(node.getNodeLeft().getSize() + node.getNodeRight().getSize() + 1);
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

            rotate.setSize(node.getSize());
            node.setSize(node.getNodeLeft().getSize() + node.getNodeRight().getSize() + 1);
        }
    }

    private void transplant(final Node<T> first, final Node<T> second) {
        if (first.getParent() == null || first.getParent().equals(createSentinel())) {
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
        getRoot().setSize(1);
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
            return treeMinimum(current.getNodeRight());
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

        while (parent != null && !parent.equals(createSentinel()) && parent.getNodeLeft().equals(current)) {
            current = parent;
            parent = parent.getParent();
        }

        if (parent == null)
            return null;

        return parent;
    }

    Node<T> getRoot() {
        return this.root;
    }

    void setRoot(final Node<T> node) {
        this.root = node;
    }

    private static class Node<T extends Comparable<T>> extends SearchTree.Node<T> {

        private int size = 0;

        private COLOR color = COLOR.RED;

        enum COLOR {
            RED,
            BLACK
        }

        Node(final T data, final SearchTree.Node<T> parent, final SearchTree.Node<T> left, final SearchTree.Node<T> right) {
            super(data, parent, left, right);
        }

        int getSize() {
            return size;
        }

        void setSize(int size) {
            this.size = size;
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

        Node<T> getCousineLeft() {
            return this.getParent().getNodeLeft();
        }

        Node<T> getCousineRight() {
            return this.getParent().getNodeRight();
        }

        Node<T> getGrandParent() {
            return this.getParent().getParent();
        }

        Node<T> getUncleLeft() {
            return this.getParent().getParent().getNodeLeft();
        }

        Node<T> getUncleRight() {
            return this.getParent().getParent().getNodeRight();
        }
    }
}
