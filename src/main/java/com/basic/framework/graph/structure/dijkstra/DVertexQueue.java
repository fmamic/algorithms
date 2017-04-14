package com.basic.framework.graph.structure.dijkstra;

public class DVertexQueue implements Comparable {

    private Integer distance;

    private int key;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(final Integer distance) {
        this.distance = distance;
    }

    public int getKey() {
        return key;
    }

    public void setKey(final int key) {
        this.key = key;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final DVertexQueue that = (DVertexQueue) o;

        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return distance;
    }

    public int compareTo(final Object o) {
        return this.getDistance().compareTo(((DVertexQueue)o).getDistance());
    }
}
