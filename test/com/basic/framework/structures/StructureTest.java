package com.basic.framework.structures;

import com.basic.framework.exception.QueueOutOfSpaceException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
