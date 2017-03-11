package com.basic.framework.graph.structure;

public class Depth {

    private Color color = Color.WHITE;

    private int distance = 0;

    private int startTime = 0;

    private int endTime = 0;

    private Vertex predecessor = null;

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(final int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(final int endTime) {
        this.endTime = endTime;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(final Vertex predecessor) {
        this.predecessor = predecessor;
    }
}
