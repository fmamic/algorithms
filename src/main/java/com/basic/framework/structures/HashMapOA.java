package com.basic.framework.structures;

import java.util.Arrays;
import java.util.Random;

// Open addressing hash map
public class HashMapOA<K, V> implements Map<K, V> {

    private int length = 10;

    private int size = 0;

    private int qc1 = 0;
    private int qc2 = 0;

    private Object[] elements;

    public HashMapOA() {
        final Random random = new Random();
        qc1 = random.nextInt(100000) + 1;
        qc2 = random.nextInt(100000) + 1;

        elements = new Object[length];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        int i = 0;

        while (elements[hash(key, i)] != null) {

            if (elements[hash(key, i)] instanceof Boolean) {
                i++;
                continue;
            }

            final Entry keyEntry = new Entry(key);
            final Entry entry = (Entry) elements[hash(key, i)];
            if (entry.equals(keyEntry)) {
                return (V) entry.value;
            }
            i++;
        }

        return null;
    }

    public void put(K key, V value) {
        int i = 0;

        while (elements[hash(key, i)] != null && elements[hash(key, i)] != Boolean.TRUE && i < length) {
            i++;
        }

        if (i == length) {
            resize();
            put(key, value);
            return;
        }

        elements[hash(key, i)] = new Entry<K, V>(key, value);
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
                while (newArray[hash(key, i)] != null && i < length) {
                    i++;
                }
                newArray[hash(key, i)] = new Entry<K, V>(key, value);
            }
        }

        elements = Arrays.copyOf(newArray, length);
    }

    public void remove(K key) {
        int i = 0;

        while (elements[hash(key, i)] != null) {
            @SuppressWarnings("unchecked")
            final Entry keyEntry = new Entry(key);

            if (elements[hash(key, i)] instanceof Boolean) {
                continue;
            }

            final Entry entry = (Entry) elements[hash(key, i)];
            if (entry.equals(keyEntry)) {
                elements[hash(key, i)] = true;
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
        return hashDoubleProbing(key, probe);
    }

    // Double hashing combine two auxiliary hash functions
    private int hashDoubleProbing(K key, int probe) {
        return (hashLinearProbing(key, probe) + probe * hashQuadraticProbing(key, probe)) % length;
    }

    private int hashLinearProbing(K key, int probe) {
        return (javaHash(key) + probe) % length;
    }

    private int hashQuadraticProbing(K key, int probe) {
        return (javaHash(key) + qc1 * probe + qc2 * probe * probe) % length;
    }

    private int javaHash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
