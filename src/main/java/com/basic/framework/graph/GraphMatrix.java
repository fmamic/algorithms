package com.basic.framework.graph;

import java.util.Arrays;

public class GraphMatrix {

    int size;

    int edgeSize;
    
    public int[][] matrix;

    public GraphMatrix(int size) {
        this.size = size;
        this.matrix = new int[size + 1][size + 1];

        for (int i = 0; i < size +1; i++) {
            Arrays.fill(this.matrix[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < size +1; i++) {
            this.matrix[i][i] = 0;
        }
    }

    public int getEdgeSize() {
        return this.edgeSize;
    }

    public int getSize() {
        return this.size;
    }

    public void addEdge(int i, int j) {
        this.matrix[i][j] = 1;
    }

    public void addEdge(int i, int j, int weight) {
        this.matrix[i][j] = weight;
        this.edgeSize++;
    }

    public void removeEdge(int i, int j) {
        this.matrix[i][j] = Integer.MAX_VALUE;
        this.edgeSize--;
    }

    public boolean isConnected(int i, int j) {
        return this.matrix[i][j] != Integer.MAX_VALUE;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(i + ": ");

            for (int j = 0; j < size; j++) {
                builder.append(j+ "-" + this.matrix[i][j]);
                builder.append(" ");
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}