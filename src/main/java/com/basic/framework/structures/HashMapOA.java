package com.basic.framework.structures;

import java.util.Arrays;

// Open addressing hash map
public class HashMapOA<K, V> implements Map<K, V> {

    private int length = 10;

    private int size = 0;

    private Object[] elements;

    public HashMapOA() {
        elements = new Object[length];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        int i = 0;

        while (elements[hashLinearProbing(key, i)] != null) {

            if (elements[hashLinearProbing(key, i)] instanceof Boolean) {
                i++;
                continue;
            }

            final Entry keyEntry = new Entry(key);
            final Entry entry = (Entry) elements[hashLinearProbing(key, i)];
            if (entry.equals(keyEntry)) {
                return (V) entry.value;
            }
            i++;
        }

        return null;
    }

    public void put(K key, V value) {
        int i = 0;

        while (elements[hashLinearProbing(key, i)] != null && elements[hashLinearProbing(key, i)] != Boolean.TRUE && i < length) {
            i++;
        }

        if (i == length) {
            resize();
            put(key, value);
            return;
        }

        elements[hashLinearProbing(key, i)] = new Entry<K, V>(key, value);
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        final int oldLength = length;

        length = length * 4;
        final Object[] newArray = new Object[length];

        for (int k = 0; k < oldLength; k++) {
            if (elements[k] instanceof Entry) {
                final K key = (K) ((Entry) elements[k]).key;
                final V value = (V) ((Entry) elements[k]).value;
                int i = 0;
                while (newArray[hashLinearProbing(key, i)] != null && i < length) {
                    i++;
                }
                newArray[hashLinearProbing(key, i)] = new Entry<K, V>(key, value);
            }
        }

        elements = Arrays.copyOf(newArray, length);
    }

    public void remove(K key) {
        int i = 0;

        while (elements[hashLinearProbing(key, i)] != null) {
            @SuppressWarnings("unchecked")
            final Entry keyEntry = new Entry(key);

            if (elements[hashLinearProbing(key, i)] instanceof Boolean) {
                continue;
            }

            final Entry entry = (Entry) elements[hashLinearProbing(key, i)];
            if (entry.equals(keyEntry)) {
                elements[hashLinearProbing(key, i)] = true;
                size--;
                return;
            }
            i++;
        }
    }

    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key) {
            this.key = key;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean equals(final Object obj) {
            if (obj instanceof Entry) {
                @SuppressWarnings("unchecked")
                final Entry<K, V> entry = (Entry<K, V>) obj;
                return (this.key == entry.key);
            }

            return false;
        }
    }

    private int hash(K key, int probe) {
        return hashLinearProbing(key, probe);
    }

    private int hashLinearProbing(K key, int probe) {
        return (javaHash(key) + probe) % length;
    }

    private int javaHash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
