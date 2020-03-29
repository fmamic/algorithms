package com.basic.framework.structures;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

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

    public void insert(String value) {
        for (int i = 0; i < this.hashFuncNum; i++) {
            HashFunction function = Hashing.murmur3_128(i);
            HashCode murmurHash = function.hashBytes(value.getBytes());

            int position = Math.abs((murmurHash.asInt() % (array.length -1)));
            this.array[position] = true;
        }
    }

    public boolean isPresent(String value) {
        for (int i = 0; i < this.hashFuncNum; i++) {
            HashFunction function = Hashing.murmur3_128(i);
            HashCode murmurHash = function.hashBytes(value.getBytes());

            int position = Math.abs((murmurHash.asInt() % (array.length -1)));
            if (!this.array[position]) {
                return false;
            }
        }

        return true;
    }
}