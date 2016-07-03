package com.basic.framework.structures;

public class Tree<E> {

    private Node<E> root;

    public Tree(E rootData) {
        root = new Node<E>();
        root.data = rootData;
        root.children = new ArrayList<Node<E>>();
    }

    private static class Node<E> {
        private E data;
        private Node<E> parent;
        private List<Node<E>> children;
    }
}
