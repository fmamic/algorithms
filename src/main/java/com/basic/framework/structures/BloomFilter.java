package com.basic.framework.structures;

import com.sangupta.murmur.Murmur3;

/**
 * Bloom filter data structure to check if item is in the array.
 * Gives false positives but never false negatives.
 */
public class BloomFilter {

    final boolean[] array;

    final int hashFuncNum;

    public BloomFilter(int size, int hashFuncNum) {
        this.array = new boolean[size];
        this.hashFuncNum = hashFuncNum;
    }

    public void add(String value) {
        for (int i = 0; i < this.hashFuncNum; i++) {
            long[] murmurHash = Murmur3.hash_x64_128(value.getBytes(), this.array.length, i);
            for (long num : murmurHash) {
                this.array[(int)num] = true;
            }
        }
    }

    public boolean get(String value) {
        for (int i = 0; i < this.hashFuncNum; i++) {
            long[] murmurHash = Murmur3.hash_x64_128(value.getBytes(), this.array.length, i);
            for (long num : murmurHash) {
                if (!this.array[(int)num]) {
                    return false;
                }
            }
        }

        return true;
    }
}