package com.basic.framework.greedy.algorithm.structure;

public class Item implements Comparable<Item> {

    private int weight;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    public int compareTo(final Item item) {
        if ((this.value / this.weight) > (item.value / item.weight)) {
            return 1;
        }
        else if ((this.value / this.weight) == (item.value / item.weight)) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
