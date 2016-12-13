package com.basic.framework.sort;

import java.util.ArrayList;

/**
 * Quicksort is a divide and conquer algorithm. In a divide and conquer sorting algorithm the original data is separated into two parts "divide" which
 * are individually sorted and "conquered" and then combined.
 */
public class QuickSort<T extends Comparable> {

    public void quickSort(final ArrayList<T> list) {
        quickSortRecursive(list, 0, list.size() - 1);
    }

    private void quickSortRecursive(final ArrayList<T> list, int start, int end) {
        if (start < end) {
            int q = partition(list, start, end);
            quickSortRecursive(list, start, q - 1);
            quickSortRecursive(list, q + 1, end);
        }
    }

    @SuppressWarnings("unchecked")
    private int partition(final ArrayList<T> list, final int start, final int end) {
        T pivot = list.get(end);
        int position = start - 1;

        for (int i = start; i <= end; i++) {
            if (list.get(i).compareTo(pivot) <= 0) {
                position++;
                T replace = list.get(position);
                list.set(position, list.get(i));
                list.set(i, replace);
            }
        }

        return position;
    }

}
