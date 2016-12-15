package com.basic.framework.greedy.algorithm;

import static com.basic.framework.structures.BinaryTree.*;

import java.util.List;

import com.basic.framework.greedy.algorithm.structure.HuffmanItem;
import com.basic.framework.structures.BinarySearchTree;
import com.basic.framework.structures.BinaryTree;

public class HuffmanCode {

    @SuppressWarnings("unchecked")
    public BinaryTree<HuffmanItem> huffman(final List<HuffmanItem> alphabet) {

        final BinarySearchTree<HuffmanItem> tree = new BinarySearchTree<HuffmanItem>();

        for (int i = 0; i < alphabet.size(); i++) {
            tree.insert(alphabet.get(i));
        }

        for (int i = 0; i < alphabet.size(); i++) {
            final BinaryTreeNode node = new BinaryTreeNode(alphabet.get(i));

        }

        return null;
    }

}
