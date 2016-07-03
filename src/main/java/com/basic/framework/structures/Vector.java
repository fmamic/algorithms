package com.basic.framework.structures;

public class Vector {

    protected Object[] elements;

    private Vector() {
    }

    public Vector(final int initialCapacity) {
        elements = new Object[initialCapacity];
    }

}
