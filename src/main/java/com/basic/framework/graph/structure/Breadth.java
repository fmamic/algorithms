package com.basic.framework.graph.structure;

public class Breadth {

    private Color status = Color.WHITE;

    private int distance = 0;

    private Vertex predecessor;

    public Color getStatus() {
        return status;
    }

    public void setStatus(final Color status) {
        this.status = status;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(final Vertex predecessor) {
        this.predecessor = predecessor;
    }
}
