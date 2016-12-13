package com.basic.framework.greedy.algorithm;

import java.util.ArrayList;

import com.basic.framework.greedy.algorithm.structure.Item;
import com.basic.framework.sort.QuickSort;

/**
 * Same as Knapsack01 only difference we can break items for maximizing the total value of knapsack.
 */
class FractionalKnapsack {

    int calculateGreedy(final ArrayList<Item> array, int weight) {
        final QuickSort<Item> quickSort = new QuickSort<Item>();
        quickSort.quickSort(array);

        int result = 0;
        int finalWeight = weight;
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i).getWeight() < finalWeight) {
                result += array.get(i).getValue();
                finalWeight -= array.get(i).getWeight();
            }
            else if (finalWeight != 0) {
                double percentage = finalWeight / (double) array.get(i).getWeight();
                result += percentage * array.get(i).getValue();
                break;
            }
            else {
                break;
            }
        }

        return result;
    }

}
