package com.basic.framework.greedy.algorithm;

import static com.basic.framework.structures.BinaryTree.BinaryTreeNode;

import java.util.List;

import com.basic.framework.greedy.algorithm.structure.HuffmanItem;
import com.basic.framework.structures.BinaryTree;

public class HuffmanCode {

    @SuppressWarnings("unchecked")
    public BinaryTree<HuffmanItem> huffman(final List<HuffmanItem> alphabet) {

        for (int i = 0; i < alphabet.size(); i++) {
            final BinaryTreeNode node = new BinaryTreeNode(alphabet.get(i));
        }

        return null;
    }

}
