package com.basic.framework.structures;

import com.basic.framework.exception.QueueOutOfSpaceException;
import org.junit.Assert;
import org.junit.Test;

public class StructureTest {

    @Test
    public void stackTest() {
        final Stack<String> stringStack = new Stack<String>();

        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");

        Assert.assertEquals(stringStack.toString(), "FirstSecondThird");

        stringStack.pop();
        Assert.assertEquals(stringStack.toString(), "FirstSecond");

        stringStack.pop();
        Assert.assertEquals(stringStack.toString(), "First");

        stringStack.pop();
        Assert.assertEquals(stringStack.toString(), "");

    }

    @Test
    public void queueTest() {
        final Queue<Integer> integerQueue = new Queue<Integer>();

        integerQueue.enqueue(22);
        integerQueue.enqueue(23);
        integerQueue.enqueue(24);

        Assert.assertEquals(3, integerQueue.size());
        Assert.assertEquals((Integer) 22, integerQueue.dequeue());
        Assert.assertEquals((Integer) 23, integerQueue.dequeue());
        Assert.assertEquals((Integer) 24, integerQueue.dequeue());

        integerQueue.enqueue(24);
        Assert.assertEquals((Integer) 24, integerQueue.dequeue());
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

        Assert.assertEquals(1, stringList.size());

        stringList.add("Second");
        stringList.add("Third");
    }

    @Test
    public void linkedListGetTest() {
        final List<String> stringList = new DoubleLinkedList<String>();

        stringList.add("First");

        Assert.assertEquals(1, stringList.size());

        stringList.add("Third");

        Assert.assertEquals("First", stringList.get(0));
        Assert.assertEquals("Third", stringList.get(1));
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

        Assert.assertEquals(3, stringList.size());

        stringList.delete("2");

        Assert.assertEquals(false, stringList.contains("2"));

        stringList.delete("1");
        stringList.delete("3");

        Assert.assertEquals(0, stringList.size());
        Assert.assertEquals(false, stringList.contains("1"));
        Assert.assertEquals(false, stringList.contains("3"));
    }

    @Test
    public void arrayListTest() {
        final List<String> arrayList = new ArrayList<String>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");

        Assert.assertEquals(4, arrayList.size());
        Assert.assertEquals(true, arrayList.contains("1"));
        Assert.assertEquals(true, arrayList.contains("2"));
        Assert.assertEquals(true, arrayList.contains("3"));
        Assert.assertEquals(true, arrayList.contains("4"));
        Assert.assertEquals(false, arrayList.contains("5"));

        arrayList.delete("2");
        arrayList.delete("3");

        Assert.assertEquals(false, arrayList.contains("2"));
        Assert.assertEquals(false, arrayList.contains("3"));
        Assert.assertEquals(2, arrayList.size());

        arrayList.add("3");
        Assert.assertEquals(3, arrayList.size());
        Assert.assertEquals(true, arrayList.contains("3"));
    }

    @Test
    public void singleLinkedList() {
        final List<String> singleList = new SingleLikedList<String>();

        singleList.add("1");
        singleList.add("2");
        singleList.add("3");

        singleList.delete();

        Assert.assertEquals(2, singleList.size());
    }

    @Test
    public void hashMapTest() {
        final HashMap<String, String> stringHashMap = new HashMap<String, String>();

        stringHashMap.put("key1", "value1");
        stringHashMap.put("key2", "value2");
        stringHashMap.put("key3", "value3");
        stringHashMap.put("key4", "value4");

        Assert.assertEquals("value1", stringHashMap.get("key1"));
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

        Assert.assertEquals("value1",  stringHashMap.get("key1"));
        Assert.assertEquals("value11",  stringHashMap.get("key11"));

        stringHashMap.remove("key4");

        Assert.assertEquals(10, stringHashMap.size());

        Assert.assertEquals("value1",  stringHashMap.get("key1"));
        Assert.assertEquals("value11",  stringHashMap.get("key11"));
        Assert.assertEquals(null,  stringHashMap.get("key4"));
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

        Assert.assertEquals(true, tree.search(2));
        Assert.assertEquals(false, tree.search(33));

        Assert.assertEquals((Integer)20, tree.maximum());
        Assert.assertEquals((Integer)2, tree.minimum());

        Assert.assertEquals((Integer)17, tree.successor(15));
        Assert.assertEquals((Integer)15, tree.successor(13));

    }

}
