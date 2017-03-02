package com.basic.framework.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortTest {

    @Test
    public void basicTest() {
        final BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        final List<Integer> list = new ArrayList<Integer>();

        list.add(44);
        list.add(4);
        list.add(6);
        list.add(89);
        list.add(48);

        bubbleSort.sort(list);

        assertEquals((Integer) 4, list.get(0));
        assertEquals((Integer) 6, list.get(1));
        assertEquals((Integer) 44, list.get(2));
        assertEquals((Integer) 48, list.get(3));
        assertEquals((Integer) 89, list.get(4));
    }

}
