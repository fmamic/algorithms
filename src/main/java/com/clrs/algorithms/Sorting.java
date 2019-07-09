package com.clrs.algorithms;

public class Sorting {

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }

    public void mergeSort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;
        mergeSort(array, p, q);
        mergeSort(array, q + 1, r);
        merge(array, p, q, r);
    }

    public void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] a1 = new int[n1 + 1];
        int[] a2 = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            a1[i] = array[p + i];
        }
        a1[n1] = Integer.MAX_VALUE;

        for (int i = 0; i < n2; i++) {
            a2[i] = array[q + 1 + i];
        }
        a2[n2] = Integer.MAX_VALUE;

        for (int i = 0, j = 0, k = p; k < r + 1; k++) {
            if (a1[i] < a2[j]) {
                array[k] = a1[i++];
            } else {
                array[k] = a2[j++];
            }
        }
    }
}
