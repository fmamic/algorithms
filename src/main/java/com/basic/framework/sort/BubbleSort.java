package com.basic.framework.sort;

import java.util.List;
import java.util.Collections;

/**
 * Sorting in O(n^2) time complexity
 */
@SuppressWarnings("unchecked")
public class BubbleSort<T extends Comparable> implements Sort<T> {

    public void sort(final List<T> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = i + 1; j < dataList.size(); j++) {
                if (dataList.get(i).compareTo(dataList.get(j)) > 0) {
                    Collections.swap(dataList, i, j);
                }
            }
        }
    }

}
