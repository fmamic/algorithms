package com.basic.framework.structures;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class BloomFilterTest {

    @Test
    public void insertAndIsNotPresentTest() {
        final BloomFilter bloomFilter = new BloomFilter(10, 3);

        bloomFilter.insert("geek");
        bloomFilter.insert("nerd");

        assertFalse(bloomFilter.isPresent("bird"));
    }

    @Test
    public void insertAndPresentTest1() {
        final BloomFilter bloomFilter = new BloomFilter(10, 3);

        bloomFilter.insert("geek");
        bloomFilter.insert("nerd");
        bloomFilter.insert("clown");
        bloomFilter.insert("nest");

        assertTrue(bloomFilter.isPresent("dog"));
    }

    @Test
    public void insertAndPresentTest2() {
        final BloomFilter bloomFilter = new BloomFilter(10, 3);

        bloomFilter.insert("geek");
        bloomFilter.insert("nerd");
        bloomFilter.insert("cat");
        bloomFilter.insert("dog");
        bloomFilter.insert("bird");

        assertTrue(bloomFilter.isPresent("cat"));
        assertTrue(bloomFilter.isPresent("dog"));
        assertTrue(bloomFilter.isPresent("dog2"));
    }
}
