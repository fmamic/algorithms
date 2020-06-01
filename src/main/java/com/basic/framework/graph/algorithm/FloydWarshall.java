package com.basic.framework.graph.algorithm;

import com.basic.framework.graph.GraphMatrix;

public class FloydWarshall {
    
    public int[][][] floydWarshallRec(GraphMatrix graphMatrix) {
        int[][][] shortestPath = new int[graphMatrix.getSize() + 1][graphMatrix.getSize() + 1][graphMatrix.getSize() + 1];

        for (int i = 0; i <= graphMatrix.getSize(); i++) {
            for (int k = 0; k <= graphMatrix.getSize(); k ++) {
                for (int l = 0; l <= graphMatrix.getSize(); l++) {
                    if (i != k)
                        shortestPath[i][k][l] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i <= graphMatrix.getSize(); i++) {
            for (int j = 0; j <= graphMatrix.getSize(); j++) {
                floydWarshallRecursive(graphMatrix, i, j, graphMatrix.getSize(), shortestPath);
            }
        }

        return shortestPath;
    }

    public int floydWarshallRecursive(GraphMatrix graphMatrix, int i, int j, int k, int[][][] shortestPath) {

        if (i == j) {
            shortestPath[i][j][k] = 0;
            return 0;
        }

        if (k == 0) {
            shortestPath[i][j][0] = graphMatrix.matrix[i][j];
            return shortestPath[i][j][0];
        }

        int direct = floydWarshallRecursive(graphMatrix, i, j, k - 1, shortestPath);
        int left = floydWarshallRecursive(graphMatrix, i, k, k - 1, shortestPath);
        int right = floydWarshallRecursive(graphMatrix, k, j, k - 1, shortestPath);
        int sum = Integer.MAX_VALUE;

        if (left != Integer.MAX_VALUE && right != Integer.MAX_VALUE) {
            sum = left + right;
        }

        shortestPath[i][j][k] = Math.min(Math.min(direct, sum), shortestPath[i][j][k]);
        
        return shortestPath[i][j][k];
    }

}