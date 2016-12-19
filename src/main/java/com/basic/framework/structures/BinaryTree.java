package com.basic.framework.structures;

/**
 * Binary Tree stands for a data structure which is made up of nodes that can only have two children references. No extra condition is required to
 * build binary tree. Thus it's more general data structure than BST (Binary search tree).
 */
public class BinaryTree<T extends Comparable> {

    private BinaryTreeNode root;
    private int size = 0;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(final BinaryTreeNode node) {
        this.root = node;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public void insert(final T data) {
        final BinaryTreeNode node = new BinaryTreeNode(data, null, null);

        if (root == null) {
            root = node;
            size++;
        }
        else {
            final BinaryTreeNode position = breadthFirstSearch(root);
            if (position.getLeft() == null) {
                position.setLeft(node);
            }
            else {
                position.setRight(node);
            }
            size++;
        }
    }

    public BinaryTreeNode search(final T data) {
        return searchNode(data, root);
    }

    private BinaryTreeNode searchNode(final T data, final BinaryTreeNode node) {

        if (node == null) {
            return null;
        }

        if (data.equals(node.getData())) {
            return node;
        }

        BinaryTreeNode resultLeft;
        BinaryTreeNode resultRight;

        resultLeft = searchNode(data, node.getLeft());
        resultRight = searchNode(data, node.getRight());

        if (resultLeft != null) {
            return resultLeft;
        }
        else {
            return resultRight;
        }
    }

    // Level Order Traversal
    private BinaryTreeNode breadthFirstSearch(final BinaryTreeNode node) {
        final Queue<BinaryTreeNode> queue = new Queue<BinaryTreeNode>();
        final Queue<BinaryTreeNode> parentQueue = new Queue<BinaryTreeNode>();

        queue.enqueue(node);

        while (queue.size() != 0) {
            final BinaryTreeNode iterNode = queue.dequeue();

            if (iterNode.getLeft() != null) {
                queue.enqueue(iterNode.getLeft());
            }
            else {
                parentQueue.enqueue(iterNode);
            }

            if (iterNode.getRight() != null) {
                queue.enqueue(iterNode.getRight());
            }
            else {
                parentQueue.enqueue(iterNode);
            }
        }

        return parentQueue.dequeue();
    }

    public static class BinaryTreeNode<T extends Comparable> implements Comparable {

        private T data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
            this.data = null;
            this.left = null;
            this.right = null;
        }

        public BinaryTreeNode(final T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BinaryTreeNode(final T data, final BinaryTreeNode left, final BinaryTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(final T data) {
            this.data = data;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(final BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(final BinaryTreeNode right) {
            this.right = right;
        }

        @SuppressWarnings("unchecked")
        public int compareTo(final Object o) {
            return data.compareTo(((BinaryTreeNode) o).data);
        }
    }
}
