package com.basic.framework.greedy.algorithm;

import static com.basic.framework.structures.BinaryTree.*;

import java.util.List;

import com.basic.framework.greedy.algorithm.structure.HuffmanItem;
import com.basic.framework.structures.PriorityQueue;

class HuffmanCode {

    @SuppressWarnings("unchecked")
    BinaryTreeNode huffman(final List<HuffmanItem> alphabet) {

        final PriorityQueue<BinaryTreeNode<HuffmanItem>> priorityQueue = new PriorityQueue<BinaryTreeNode<HuffmanItem>>();

        for (final HuffmanItem item : alphabet) {
            priorityQueue.insert(new BinaryTreeNode<HuffmanItem>(item));
        }

        while (priorityQueue.getSize() > 1) {
            final BinaryTreeNode<HuffmanItem> first = priorityQueue.extractMin();
            final BinaryTreeNode<HuffmanItem> second = priorityQueue.extractMin();
            final BinaryTreeNode<HuffmanItem> parent = new BinaryTreeNode(
                    new HuffmanItem(null, first.getData().getFrequency() + second.getData().getFrequency()), first, second);

            priorityQueue.insert(parent);
        }

        return priorityQueue.extractMin();
    }

    String constructHuffmanCode(final BinaryTreeNode<HuffmanItem> node, final HuffmanItem item) {

        while (item.getFrequency().compareTo(node.getData().getFrequency()) == 0) {

        }

        return "";
    }

}
