package com.basic.framework.structures;

import static com.basic.framework.structures.BinaryTree.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.basic.framework.exception.QueueOutOfSpaceException;

public class StructureTest {

    @Test
    public void stackTest() {
        final Stack<String> stringStack = new Stack<String>();

        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");

        assertEquals(stringStack.toString(), "FirstSecondThird");

        stringStack.pop();
        assertEquals(stringStack.toString(), "FirstSecond");

        stringStack.pop();
        assertEquals(stringStack.toString(), "First");

        stringStack.pop();
        assertEquals(stringStack.toString(), "");

    }

    @Test
    public void queueTest() {
        final Queue<Integer> integerQueue = new Queue<Integer>();

        integerQueue.enqueue(22);
        integerQueue.enqueue(23);
        integerQueue.enqueue(24);

        assertEquals(3, integerQueue.size());
        assertEquals((Integer) 22, integerQueue.dequeue());
        assertEquals((Integer) 23, integerQueue.dequeue());
        assertEquals((Integer) 24, integerQueue.dequeue());

        integerQueue.enqueue(24);
        assertEquals((Integer) 24, integerQueue.dequeue());
    }

    @Test(expected = QueueOutOfSpaceException.class)
    public void queueOutOfSpaceTest() {
        final Queue<Integer> integerQueue = new Queue<Integer>();

        integerQueue.enqueue(22);
        integerQueue.enqueue(23);
        integerQueue.enqueue(24);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
        integerQueue.enqueue(23);
    }

    @Test
    public void linkedListTest() {
        final List<String> stringList = new DoubleLinkedList<String>();

        stringList.add("First");

        assertEquals(1, stringList.size());

        stringList.add("Second");
        stringList.add("Third");
    }

    @Test
    public void linkedListGetTest() {
        final List<String> stringList = new DoubleLinkedList<String>();

        stringList.add("First");

        assertEquals(1, stringList.size());

        stringList.add("Third");

        assertEquals("First", stringList.get(0));
        assertEquals("Third", stringList.get(1));
    }

    @Test
    public void linkedListContainsTest() {
        final List<String> stringList = new DoubleLinkedList<String>();

        stringList.add("First");
        stringList.add("Third");

        stringList.contains("First");
        stringList.contains("Third");

        stringList.add("4");
        stringList.add("5");

        stringList.contains("4");
        stringList.contains("5");
    }

    @Test
    public void linkedListDeleteTest() {
        final List<String> stringList = new DoubleLinkedList<String>();

        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        assertEquals(3, stringList.size());

        stringList.delete("2");

        assertEquals(false, stringList.contains("2"));

        stringList.delete("1");
        stringList.delete("3");

        assertEquals(0, stringList.size());
        assertEquals(false, stringList.contains("1"));
        assertEquals(false, stringList.contains("3"));
    }

    @Test
    public void arrayListTest() {
        final List<String> arrayList = new ArrayList<String>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");

        assertEquals(4, arrayList.size());
        assertEquals(true, arrayList.contains("1"));
        assertEquals(true, arrayList.contains("2"));
        assertEquals(true, arrayList.contains("3"));
        assertEquals(true, arrayList.contains("4"));
        assertEquals(false, arrayList.contains("5"));

        arrayList.delete("2");
        arrayList.delete("3");

        assertEquals(false, arrayList.contains("2"));
        assertEquals(false, arrayList.contains("3"));
        assertEquals(2, arrayList.size());

        arrayList.add("3");
        assertEquals(3, arrayList.size());
        assertEquals(true, arrayList.contains("3"));
    }

    @Test
    public void singleLinkedList() {
        final List<String> singleList = new SingleLikedList<String>();

        singleList.add("1");
        singleList.add("2");
        singleList.add("3");

        singleList.delete();

        assertEquals(2, singleList.size());
    }

    @Test
    public void hashMapTest() {
        final HashMap<String, String> stringHashMap = new HashMap<String, String>();

        stringHashMap.put("key1", "value1");
        stringHashMap.put("key2", "value2");
        stringHashMap.put("key3", "value3");
        stringHashMap.put("key4", "value4");

        assertEquals("value1", stringHashMap.get("key1"));
    }

    @Test
    public void hashOAMapTest() {
        final HashMapOA<String, String> stringHashMap = new HashMapOA<String, String>();

        stringHashMap.put("key1", "value1");
        stringHashMap.put("key2", "value2");
        stringHashMap.put("key3", "value3");
        stringHashMap.put("key4", "value3");
        stringHashMap.put("key5", "value3");
        stringHashMap.put("key6", "value3");
        stringHashMap.put("key7", "value3");
        stringHashMap.put("key8", "value3");
        stringHashMap.put("key9", "value3");
        stringHashMap.put("key10", "value3");
        stringHashMap.put("key11", "value11");

        assertEquals("value1", stringHashMap.get("key1"));
        assertEquals("value11", stringHashMap.get("key11"));

        stringHashMap.remove("key4");

        assertEquals(10, stringHashMap.size());

        assertEquals("value1", stringHashMap.get("key1"));
        assertEquals("value11", stringHashMap.get("key11"));
        assertEquals(null, stringHashMap.get("key4"));
    }

    @Test
    public void binarySearchTreeTest() {
        final BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(15);

        tree.insert(6);
        tree.insert(18);
        tree.insert(3);
        tree.insert(7);
        tree.insert(17);
        tree.insert(20);
        tree.insert(2);
        tree.insert(4);
        tree.insert(13);
        tree.insert(9);

        assertEquals(true, tree.search(2));
        assertEquals(false, tree.search(33));

        assertEquals((Integer) 20, tree.maximum());
        assertEquals((Integer) 2, tree.minimum());

        assertEquals((Integer) 17, tree.successor(15));
        assertEquals((Integer) 15, tree.successor(13));

        assertEquals((Integer) 2, tree.predecessor(3));
        assertEquals((Integer) 6, tree.predecessor(7));

    }

    @Test
    public void binarySearchTreeDeleteTest() {
        final BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(12);

        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(13);
        tree.insert(17);
        tree.insert(1);
        tree.insert(9);
        tree.insert(14);
        tree.insert(20);
        tree.insert(8);
        tree.insert(11);
        tree.insert(18);

        tree.delete(1);

        assertEquals(false, tree.search(1));

        tree.insert(1);
        tree.delete(3);

        assertEquals(true, tree.search(1));

        tree.delete(1);

        tree.insert(3);
        tree.insert(1);

        tree.delete(7);

        assertEquals(false, tree.search(7));
        assertEquals(true, tree.search(11));

        tree.delete(15);

        assertEquals(false, tree.search(15));
        assertEquals(true, tree.search(13));
    }

    @Test
    public void redBlackTreeTest() {
        final RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>(11);

        redBlackTree.insert(21);
        redBlackTree.insert(25);
        redBlackTree.insert(19);
        redBlackTree.insert(4);

        assertEquals(true, redBlackTree.search(11));
        assertEquals(true, redBlackTree.search(4));
        assertEquals(true, redBlackTree.search(19));
        assertEquals(false, redBlackTree.search(122));
        assertEquals(false, redBlackTree.search(17));
    }

    @Test
    public void redBlackTreeTestMinMax() {
        final RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>(38);

        redBlackTree.insert(21);
        redBlackTree.insert(55);
        redBlackTree.insert(12);

        assertEquals(12, (int) redBlackTree.minimum());
        assertEquals(55, (int) redBlackTree.maximum());
        assertEquals(21, (int) redBlackTree.successor(12));
        assertEquals(21, (int) redBlackTree.predecessor(38));
        assertEquals(true, redBlackTree.predecessor(12) == null);
    }

    @Test
    public void redBlackTreeDelete30() {
        final RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>(10);

        redBlackTree.insert(5);
        redBlackTree.insert(30);
        redBlackTree.insert(-5);
        redBlackTree.insert(7);
        redBlackTree.insert(20);
        redBlackTree.insert(38);
        redBlackTree.insert(32);
        redBlackTree.insert(41);
        redBlackTree.insert(35);

        redBlackTree.delete(30);

        assertEquals(false, redBlackTree.search(30));
    }

    @Test
    public void redBlackTreeDelete10() {
        final RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>(10);

        redBlackTree.insert(5);
        redBlackTree.insert(30);
        redBlackTree.insert(-5);
        redBlackTree.insert(7);
        redBlackTree.insert(20);
        redBlackTree.insert(38);
        redBlackTree.insert(32);
        redBlackTree.insert(41);
        redBlackTree.insert(35);

        redBlackTree.delete(10);

        assertEquals(false, redBlackTree.search(10));
    }

    @Test
    public void avlTreeInsertTest() {
        final AVLTree<Integer> avlTree = new AVLTree<Integer>(15);

        avlTree.insert(11);
        avlTree.insert(25);
        avlTree.insert(30);
        avlTree.insert(35);
    }

    @Test
    public void treapTreeInsertTest() {
        final Treap<String, Integer> treapTree = new Treap<String, Integer>("G", 4);

        treapTree.insert("B", 7);
        treapTree.insert("H", 5);
        treapTree.insert("A", 10);
        treapTree.insert("D", 9);
        treapTree.insert("K", 65);
        treapTree.insert("C", 25);
        treapTree.insert("E", 23);
        treapTree.insert("I", 73);
        treapTree.insert("F", 2);
    }

    @Test
    public void rbTreeSmallestElemTest() {
        final RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>(10);

        redBlackTree.insert(5);
        redBlackTree.insert(30);
        redBlackTree.insert(-5);
        redBlackTree.insert(7);
        redBlackTree.insert(20);
        redBlackTree.insert(38);
        redBlackTree.insert(32);
        redBlackTree.insert(41);
        redBlackTree.insert(35);

        redBlackTree.inorderPrint();

        assertEquals(7, (int) redBlackTree.selectElement(3));
        assertEquals(7, redBlackTree.rankElement(32));
    }

    @Test
    public void rbIntervalTest() {
        final Interval interval = new Interval(16, 21);
        final Interval interval2 = new Interval(8, 9);
        final Interval interval3 = new Interval(25, 30);
        final Interval interval4 = new Interval(5, 8);
        final Interval interval5 = new Interval(15, 23);
        final Interval interval6 = new Interval(0, 3);
        final Interval interval7 = new Interval(6, 10);
        final Interval interval8 = new Interval(17, 19);
        final Interval interval9 = new Interval(26, 26);
        final Interval interval10 = new Interval(19, 20);

        @SuppressWarnings("unchecked")
        final RedBlackTree<Interval> redBlackTree = new RedBlackTree<Interval>(interval);

        redBlackTree.insert(interval2);
        redBlackTree.insert(interval3);
        redBlackTree.insert(interval4);
        redBlackTree.insert(interval5);
        redBlackTree.insert(interval6);
        redBlackTree.insert(interval7);
        redBlackTree.insert(interval8);
        redBlackTree.insert(interval9);
        redBlackTree.insert(interval10);

        redBlackTree.inorderPrint();

        final Interval search = new Interval(7, 10);

        assertEquals(interval2, redBlackTree.intervalSearch(search));
    }

    @Test
    public void binaryTreeTest() {
        final BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();

        binaryTree.insert(22);
        binaryTree.insert(11);
        binaryTree.insert(33);
        binaryTree.insert(1);
        binaryTree.insert(2);

        assertEquals(5, binaryTree.getSize());

        BinaryTreeNode node = binaryTree.search(1);

        assertEquals(1, node.getData());
    }

    @Test
    public void binaryHeapTest() {
        final BinaryHeap<Integer> binaryHeap = new BinaryHeap<Integer>();

        binaryHeap.insert(6);
        binaryHeap.insert(7);
        binaryHeap.insert(12);
        binaryHeap.insert(10);
        binaryHeap.insert(15);
        binaryHeap.insert(17);
        binaryHeap.insert(5);

        assertEquals(7, binaryHeap.getSize());

        binaryHeap.deleteMin();

        assertEquals(6, binaryHeap.getSize());
    }

    @Test
    public void priorityQueueTest() {
        final PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        queue.insert(6);
        queue.insert(7);
        queue.insert(12);
        queue.insert(10);
        queue.insert(15);
        queue.insert(17);
        queue.insert(5);

        assertEquals((Integer) 5, queue.extractMin());
        assertEquals((Integer) 6, queue.extractMin());

        assertEquals((Integer) 7, queue.extractMin());
        assertEquals((Integer) 10, queue.extractMin());

        assertEquals((Integer) 12, queue.extractMin());
        assertEquals((Integer) 15, queue.extractMin());

        assertEquals((Integer) 17, queue.extractMin());

    }

    @Test
    public void btreeInsertTest() {
        final BTree<Integer> bTree = new BTree<Integer>();

        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(30);

        assertEquals(null, bTree);
    }

    @Test
    public void disjointSet() {
        final DisjointSet disjointSet = new DisjointSet();

        disjointSet.makeSet(1);
        disjointSet.makeSet(2);
        disjointSet.makeSet(3);
        disjointSet.makeSet(4);
        disjointSet.makeSet(5);
        disjointSet.makeSet(6);
        disjointSet.makeSet(7);

        disjointSet.union(1, 2);
        disjointSet.union(2, 3);
        disjointSet.union(4, 5);
        disjointSet.union(6, 7);
        disjointSet.union(5, 6);
        disjointSet.union(3, 7);

        assertEquals((Integer) 4, disjointSet.findSet(1));
        assertEquals((Integer) 4, disjointSet.findSet(2));
        assertEquals((Integer) 4, disjointSet.findSet(3));
        assertEquals((Integer) 4, disjointSet.findSet(4));
        assertEquals((Integer) 4, disjointSet.findSet(5));
        assertEquals((Integer) 4, disjointSet.findSet(6));
        assertEquals((Integer) 4, disjointSet.findSet(7));
    }
}
