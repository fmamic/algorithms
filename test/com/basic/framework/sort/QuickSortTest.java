package com.basic.framework.sort;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class QuickSortTest {

    @Test
    public void quickSortTest() {
        final QuickSort<Integer> sortIntegers = new QuickSort<Integer>();

        final ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(9);
        arrayList.add(7);
        arrayList.add(5);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(2);
        arrayList.add(14);
        arrayList.add(3);
        arrayList.add(10);
        arrayList.add(6);

        sortIntegers.quickSort(arrayList);

        assertEquals(new Integer(2), arrayList.get(0));
        assertEquals(new Integer(3), arrayList.get(1));
        assertEquals(new Integer(5), arrayList.get(2));
        assertEquals(new Integer(6), arrayList.get(3));
        assertEquals(new Integer(7), arrayList.get(4));
        assertEquals(new Integer(9), arrayList.get(5));
        assertEquals(new Integer(10), arrayList.get(6));
        assertEquals(new Integer(11), arrayList.get(7));
        assertEquals(new Integer(12), arrayList.get(8));
        assertEquals(new Integer(14), arrayList.get(9));
    }

}
