package com.basic.framework.structures;

public interface Map<K, V> {

    int size();

    V get(K key);

    void put(K key, V value);

    void remove(K key);
}
