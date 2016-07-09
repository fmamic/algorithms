package com.basic.framework.structures;

import java.util.Random;

public class HashMap<K, V> implements Map<K, V> {

    private static final int SIZE = 15;
    private static final int UNIVERSAL_PRIME = 17;

    private ArrayList<DoubleLinkedList<Entry<K, V>>> elements;

    private int size = 0;
    private int a;
    private int b;

    public HashMap() {
        final Random random = new Random();
        a = random.nextInt(UNIVERSAL_PRIME - 1) + 1;
        b = random.nextInt(UNIVERSAL_PRIME);

        elements = new ArrayList<DoubleLinkedList<Entry<K, V>>>(SIZE);
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        final int hash = hash(key);
        final int index = getBucketNumber(hash);
        final DoubleLinkedList<Entry<K, V>> list = elements.get(index);
        final Entry<K, V> entry = new Entry<K, V>(key);

        return list.get(entry).value;
    }

    public void put(K key, V value) {
        final int hash = hash(key);
        final int index = getBucketNumber(hash);
        final DoubleLinkedList list = elements.get(index);
        final Entry<K, V> entry = new Entry<K, V>(key, value);

        if (list == null) {
            elements.add(index, new DoubleLinkedList<Entry<K, V>>());
        }

        elements.get(index).add(entry);
        size++;
    }

    public void remove(K key) {
        final int hash = hash(key);
        final int index = getBucketNumber(hash);
        final DoubleLinkedList<Entry<K, V>> list = elements.get(index);

        final Entry<K, V> entry = new Entry<K, V>(key);

        list.delete(entry);
        size--;
    }

    private int hash(K key) {
        return universalHash(key);
    }

    private int javaHash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int divisionHash(K key) {
        return (key == null) ? 0 : (key.hashCode() % SIZE);
    }

    private int multiHash(K key) {
        final Double constant = (Math.sqrt(5) - 1) / 2; // recommended value for multi hash
        return (key == null) ? 0 : ((Double) (SIZE * (((key.hashCode() * constant) % 1)))).intValue();
    }

    private int universalHash(K key) {
        return (key == null) ? 0 : ((a * key.hashCode() + b) % UNIVERSAL_PRIME) % SIZE;
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

    private int getBucketNumber(final int hash) {
        return hash & SIZE;
    }
}
