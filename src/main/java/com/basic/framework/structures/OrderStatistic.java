package com.basic.framework.structures;

public interface OrderStatistic<T extends Comparable> {

    int rankElement(T data);

    T selectElement(int position);

}
